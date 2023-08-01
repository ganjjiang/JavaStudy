import javax.swing.JOptionPane;

public class ThreadTest08 {
	public static void main(String[] args) throws Exception {
		
		ThreadTest08_1 th1 = new ThreadTest08_1();
		th1.start();
		
		//System.out.println("isInterrupted():"+ th1.isInterrupted());
		
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력하신 값은" + input + "입니다.");
		
		th1.interrupt(); //interrupt()를 호출하면, interrupted상태가 true가 된다. 
		
		//System.out.println("isInterrupted():"+ th1.isInterrupted());

	}

}

class ThreadTest08_1 extends Thread {
	
	public void run() {		
		int i = 10; 
		
		//일단 원하는 바대로 안됨....시간이 쏜살같이 흘러감 
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0; x<2500000000L; x++); //시간지연
		}
		
		System.out.println("isInterrupted():"+ this.isInterrupted());
		System.out.println("interrupted():"+ Thread.interrupted());
		System.out.println("interrupted():"+ Thread.interrupted());
		
		
		System.out.println("카운트가 종료되었습니다.");
	}
	

}
