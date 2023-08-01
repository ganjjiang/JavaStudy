
public class ThreadTest11 {

	public static void main(String[] args) {
		
		Runnable r = new Runnable11();
		
		new Thread(r).start();
		new Thread(r).start();
		
		

	}

}

class Account {
	
	private int balance = 1000; 
	
	//읽을때도 동기화를 해주어야 읽는동안값이 바뀔수 없음으로 
	public synchronized int getBalance() {
		return balance;
	}
	
//	public void withdraw(int money) {
//		if(balance >= money) {
//			try {
//				Thread.sleep(1000); 
//			} catch (InterruptedException e) {}
//			balance -= money; 
//		}
//	}
	
	//동기화 했음으로 잔고가 마이너스가 되지않는다. 
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {}
			balance -= money; 
		}
	}
}

class Runnable11 implements Runnable {
	Account acc = new Account(); 
	
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println("balance:"+acc.getBalance());
		}
	}
}
