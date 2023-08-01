
public class ThreadTest09 {

	public static void main(String[] args) {
		
		//MyThread r = new MyThread();
		
		MyThread th1 = new MyThread("*");  //각각의 Thread 이름을 *개수로 표시한다. 
		MyThread th2 = new MyThread("**");
		MyThread th3 = new MyThread("***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend(); //Th1 잠시 중단 
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();  //th1 다시 동작 
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {} 

	}

}

class MyThread implements Runnable {
	
	//메서드들이 deprecated됨에 따라 새로운 매서드를 생성하여 쓰레드를 제한한다. 
	//volatile : 변수의 값이 계속해서 바뀐다는 의미.=> 복사본을 쓰지말고 원본을 갖다 써라 라는 의미 
	//cpu의 코어들이 메모리에 있는 값을 복사본을 사용하지않고 Ram(메모리)에 있는 원본을 불러올린다. 
	volatile boolean suspended = false;
	volatile boolean stopped = false; 
	
	Thread th; 
	
	MyThread(String name){
		th = new Thread(this, name); //Thread(Runnable r, String neame) 
	}
	
	void start() {
		th.start();
	}
	
	void stop() {
		stopped = true;
	}
	
	void suspend() {
		suspended = true; 
	}
	
	void resume() {
		suspended = false; 
	}
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000); //Thread 이름을 1초마다 찍음 
				} catch (InterruptedException e) {} 
				
			}
		}
	}
}

