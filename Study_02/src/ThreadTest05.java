
public class ThreadTest05 {

	public static void main(String[] args) {
		ThreadTest05_1 th1 = new ThreadTest05_1();
		ThreadTest05_2 th2 = new ThreadTest05_2();

		//우선순위 지정, th1 = 5(기본) 
		//우선순위가 높다고해서 무조건 그렇게 실행되는것이 아니다. 대부분 적용이 되지만 아닌경우도 많음 
		th2.setPriority(9);
		
		System.out.println("Priority of th1(-) : "+th1.getPriority());
		System.out.println("Priority of th2(|) : "+th2.getPriority());
		
		th1.start();
		th2.start();
	}

}

class ThreadTest05_1 extends Thread {
	
	public void run() {
		for(int i =0; i < 300; i++) {
			System.out.print("-");
			for(int x=0; x<10000000; x++); //단순 시간지연, 특정작업이 너무 빨리 끝나지 않도록 
		}
	}
}

class ThreadTest05_2 extends Thread {
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
			for(int  x=0; x<10000000; x++); //단순 시간지연 
		}
	}
}