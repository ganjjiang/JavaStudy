import java.util.function.Function;

public class MethodReferenceTest01 {
	public static void main(String[] args) {
		
		//람다식 
		//Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		
		//메서드 참조 
		//Function<String, Integer> f = 클래스 네임::메서드이름 
		Function<String, Integer> f = Integer::parseInt; //메서드 참조 
		
		System.out.println(f.apply("100")+200);
		
		
		//Supplier는 입력은 없고 출력만 있다. => 객체만 만들어서 줌 
//		Supplier<MyClass> s = ()-> new MyClass();
//		Supplier<MyClass> s = MyClass::new;
		
		
//		Function<Integer, MyClass> s = (i)-> new MyClass(i);
		Function<Integer, MyClass> s = MyClass::new;
		
//		MyClass mc = s.get();
		MyClass mc = s.apply(100); //Function메서드는 apply
		
		
		System.out.println(mc.iv); //100 
		
//		System.out.println(s.apply()); //또다른 객체 
		
		
		
		//배열 생성시 배열 길이를 줘야 생성이 가능하므로 Function으로 쓸 수 밖에 없다. 
//		Function<Integer, int[]> b = (i) -> new int[i]; 
		Function<Integer, int[]> b = int[]::new; //메서드 참조 
		
		System.out.println(b.apply(100).length); //배열 길이가 100 
	}
}

class MyClass {
	
	int iv; 
	
	//매개변수가 있는 생성자를 만들었으면 전달인자와 반환인자가 생겼음으로 Supplier -> Function으로 바꿔야한다. 
	MyClass(int iv){
		this.iv =iv; 
	}
} 
