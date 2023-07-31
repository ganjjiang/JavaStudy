
public class ThreadTest02 {

	static long startTime = 0; 
	
	public static void main(String[] args) {
		ThreadTest02_1 th1 = new ThreadTest02_1();
		ThreadTest02_2 th2 = new ThreadTest02_2();
		
		th1.start();
		th2.start(); 
		
		startTime = System.currentTimeMillis();
		
		//join메서드는 다른 쓰레드의 작업이 끝날때까지 기다려주는 메서드
		try { 
			th1.join(); //main쓰레드가 th1의 작업이 끝날때까지 기다린다. 
			th2.join(); //main쓰레드가 th2의 작업이 끝날때까지 기다린다. 
		} catch(InterruptedException e ) {} 
		
		//만약 join()메서드가 없다면 main쓰레드가 먼저 작업을 끝내기때문에 소요시간이 가장 앞에 온다. 
		//main쓰레드는 나머지 두 쓰레드를 만들고는 아무런 할일이 없기때문에 가장먼저 종료된다. 
		System.out.println("소요시간" + (System.currentTimeMillis() - startTime)); 
	}

}

class ThreadTest02_1 extends Thread {
	public void run() {
		for(int i =0; i <300; i++) {
			System.out.print(new String("-"));
		}
	}
}



class ThreadTest02_2 extends Thread {
	public void run() {
			for(int i =0; i < 300; i++) {
				System.out.print(new String("|"));
			}
		}
	}
