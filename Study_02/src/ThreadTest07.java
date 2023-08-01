
public class ThreadTest07 {
	public static void main(String[] args) {
		
		ThreadTest07_1 th1 = new ThreadTest07_1();
		ThreadTest07_2 th2 = new ThreadTest07_2();

		th1.start();
		th2.start();
		
		delay(2*1000);
		
//		try {
//			th1.sleep(2000); //쓰레드1을 잠자게 했으나 main 메서드가 잠자게됨. 
//		} catch(InterruptedException e) {} 
		
		System.out.println("<<mian종료>>");
	}
	
	//코드가 더 간단해짐 
	static void delay(long millis) {
		try {
			Thread.sleep(2000); 
		} catch(InterruptedException e) {} 
	}
}

class ThreadTest07_1 extends Thread {
	
	public void run() {
		for(int i =0; i <300; i++) System.out.println("-");
		System.out.println("<<th1 종료>>");
	}
}

class ThreadTest07_2 extends Thread {
	
	public void run() {
		for(int i=0; i<300; i++) System.out.println("-");
		System.out.println("<<th2 종료>>");
	}
	
}
