import javax.swing.JOptionPane;

// 멀티쓰레드
public class ThreadTest04 {

	public static void main(String[] args) throws Exception {
		//작업1
		ThreadTest04_1 th1 = new ThreadTest04_1();
		th1.start();
		
		//작업2가 실행되는 와중에도 작업1은 실행되고 있으니 블락킹이 일어나지않아 싱글쓰레드보다 시간을 단축시킬 수 있다. 
		
		//작업2
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력하신값은"+input+"입니다.");

	}

}

class ThreadTest04_1 extends Thread {
	
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			}catch (Exception e) {}
		}
	}
}
