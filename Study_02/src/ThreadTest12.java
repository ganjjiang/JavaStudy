import java.util.ArrayList;

class Customer implements Runnable {

	private Table table;
	private String food; 

	Customer(Table table, String food){
		this.table = table;
		this.food = food; 
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			}catch (InterruptedException e ) {} 
			String name = Thread.currentThread().getName();

			table.remove(food);
			System.out.println(name+" ate a " + food);
		}
	}
}

class Cook implements Runnable {

	private Table table; 

	Cook(Table table) {
		this.table = table;
	}

	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {} 
		}
	}
}

class Table {
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		//테이블에 음식 꽉찼을 때 
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println("테이블이 꽉찼음으로////"+name+" is waiting.");
			try {
				wait(); //요리사를 기다리게 해야한다. (놓을 공간이 없음으로 요리사를 대기공간으로)
				Thread.sleep(500);
			}catch(InterruptedException e) {}
		}
		dishes.add(dish);
		notify(); //그렇지 않으면 테이블에 음식을 추가해야하므로 음식을 기다리는 손님에게 통보를 한다. (음식이 놓여졌음으로) 
		System.out.println("테이블에 음식이 놓여졌음///"+"Dishes: " + dishes.toString());
	}

	public void remove(String dishName) {
		//동기화를 사용하여 오류는 없지만 계속해서 다른 쓰레드들이 접근하지 못하니 계속 음식을 기다리기만 한다. 
		//음식이 없을 때, 손님이 Table에 lock을 쥐고 안 놓는다. => 요리사가 Table이 lock이 걸려있으니 음식을 놓을 수 없다. 
		//음식이 없을 때, wait()으로 손님 lock을 풀고 음식이 나오면 notify()로 손님께 알려준다. 
		synchronized (this) {
			String name = Thread.currentThread().getName();
			while(dishes.size() == 0) {
				System.out.println("테이블이 비어졌음으로///"+ name+" is waiting.");
				try {
					wait(); // 음식을 소비하는 사람이 CUST쓰레드를 기다리게한다.  lock을 반납하고 대기실에서 기다린다. 
					Thread.sleep(500);
				} catch (InterruptedException e) {} 
			}

			while(true) {
				for(int i =0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); //음식이 꽉차있다면 (쉬고있는)요리사에게 알려준다. => 요리사도 대기실에 가있고 손님은 테이블에 착석하여 음식을 소비한다. 
						return;
					}
				}// end of for 

				//원하는 음식이 없을 경우 대기석에 가서 기다린다.
				try {
					System.out.println("원하는 음식이 없음으로///"+name+" is waiting.");
					wait(); //원하는 음식이 없는 CUST쓰레드를 기다린다. 
					Thread.sleep(500);
				}catch (InterruptedException e) {}
			}//while(true)

		}//synchronized 
	}
	public int dishNum() {
		return dishNames.length;
	}
}



public class ThreadTest12 {

	public static void main(String[] args) throws Exception {
		Table table = new Table();

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();

		Thread.sleep(100);
		System.out.println(0);


	}

}
