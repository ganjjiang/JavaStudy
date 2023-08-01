
public class ThreadTest10 {

	static long startTime = 0;
	public static void main(String[] args) {
		
		Thread10_1 th1 = new Thread10_1();
		Thread10_2 th2 = new Thread10_2();
		
		th1.start();
		th2.start();
		
		startTime = System.currentTimeMillis(); //현재시간 저장 
		
		//join()을 쓰지않으면 main쓰레드는 제일먼저 끝난다. 
		try {
			th1.join(); //main이 th1쓰레드의 작업이 끝날때까지 기다린다. 
			th2.join(); //main이 th2쓰레드의 작업이 끝날때까지 기다린다. 
		} catch(InterruptedException e) {} 
		
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime) );

	}

}

class Thread10_1 extends Thread {
	public void run() {
		for(int i=0; i <300; i++) {
			System.out.print(new String("-"));
		}
	}
}

class Thread10_2 extends Thread {
	public void run() {
		for(int i=0; i <300; i++) {
			System.out.print(new String("|"));
		}
	}
}

