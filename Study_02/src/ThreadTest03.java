import javax.swing.JOptionPane;

//싱글쓰레드 
public class ThreadTest03 {
	public static void main(String[] args) throws Exception {
		//작업 1
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은" + input + "입니다");
		
		//사용자가 입력을 하기 전까지 작업2로 넘어가지 못한다. 
		//이 작업이 중단되는 시간을 I/O 블락킹이라고 한다. 
		
		//작업2
		for(int i =0; i >0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);//1초간 시간을 지연한다. 
			}catch(Exception e) {}
		}
	}
}
