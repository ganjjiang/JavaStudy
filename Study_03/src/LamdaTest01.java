
public class LamdaTest01 {
	public static void main(String[] args) {
		//		Object obj = (a, b) -> a > b? a : b // 람다식. 함수형 인터페이스라서 참조변수에 담을 수 없다. 오류.
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a:b; //메서드만 필요하지만 자바에서는 메서드만을 쓸 수 없기때문에 람다식을 사용한다. 
			}
		};
		
		//int value = obj.max(3, 5); //Object라는 객체는 max라는 메서드가 없기때문에 호출할 수 없다. 오류. 
									// 형변환도 안됨 

	}

}
