@FunctionalInterface
interface MyFunction2 {
	void run(); 
}

public class LamdaTest02 {
	
	static void execute(MyFunction2 f) { //매개변수 타입이 MyFunction인 메서드 
		f.run(); 
	}
	
	static MyFunction2 getMyFunction() { //반환타입이 MyFucntion(함수형인터페이스)인 메서드 
//		MyFunction2 f = ()-> System.out.println("f3.run()");
//		return f; 
		
		//같다 
		return () -> System.out.println("f3.run");
	}
	
	public static void main(String[] args) {
		//람다식으로 MyFunction의 run()을 구현 
		MyFunction2 f1 = () -> System.out.println("f1.run()");
		
		//익명클래스로 run()을 구현. 함수형 인터페이스를 직접 구현  
		MyFunction2 f2 = new MyFunction2() {
			public void run() {
				System.out.println("f2.run()");
			}
		};
		
		MyFunction2 f3 = getMyFunction(); 
		
		f1.run();
		f2.run(); 
		f3.run(); 
		
		//execute(f1);
		//위와 같음
		execute( () -> System.out.println("f1.run()") );
		execute( ()-> System.out.println("run()")  ); 

	}

}
