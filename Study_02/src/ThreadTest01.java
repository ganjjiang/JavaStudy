
public class ThreadTest01 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1(); 
		
		Runnable r = new ThreadEx1_2(); 
		Thread t2 = new Thread(r);  //생성자 Thread(Runnable target) 
		
		t1.start();
		t2.start();

	}

}
//별도의 쓰레드로 나눠서 작업 -> 싱글 쓰레드처럼 위 코드 작업이 끝나면 뒤 코드가 실행하는게 아니라 랜덤으로 섞여서 작업이 되어 매번 다르게 출력된다. 
class ThreadEx1_1 extends Thread { //1. Thread클래스를 상속하여 Thread 구현 
	
	public void run() { //쓰레드가 수행할 작업을 작성 
		for(int i=0; i<5; i++) {
			System.out.println(this.getName()); // 조상인 Thread의 getName()을 호출 
		}
	}
}

class ThreadEx1_2 implements Runnable { //2. Runnable 인터페이스를 구현해서 쓰레드를 구현 
	
	public void run() { //쓰레드가 수행할 작업을 작성 
		for(int i =0; i <5; i++) {
			//Thread.currentThread() - 현재 실행중인 Thread를 반환한다. 
			System.out.println(Thread.currentThread().getName()); 
		}
	}
}