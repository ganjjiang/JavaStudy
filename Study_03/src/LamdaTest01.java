
public class LamdaTest01 {
	public static void main(String[] args) {
		//		Object obj = (a, b) -> a > b? a : b // 람다식. 함수형 인터페이스라서 참조변수에 담을 수 없다. 오류.
		
		//int value = obj.max(3, 5); //Object라는 객체는 max라는 메서드가 없기때문에 호출할 수 없다. 오류. 
		// 형변환도 안됨 
		
		
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) { //오버라이딩 규칙 - 접근제어자는 좁게 못 바꾼다 
//				return a > b ? a:b; //메서드만 필요하지만 자바에서는 메서드만을 쓸 수 없기때문에 람다식을 사용한다. 
//			}
//		};
		
		// 람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다. 
		MyFunction f = (a, b) -> a > b? a : b; //람다로 간단하게 표현가능하다. 
		
		int value = f.max(3, 5);
		System.out.println(value);
	}

}

@FunctionalInterface //안붙여도 되지만 애너테이션을 붙여주면 이것이 함수형 인터페이스인지를 분간해준다. 
interface MyFunction {
//	public abstract int max(int a, int b);
	 int max(int a, int b); // 같다 
	 //람다식과 전달인자개수는 같아야한다. 
}