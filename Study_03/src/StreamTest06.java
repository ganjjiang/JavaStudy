import java.util.Optional;

public class StreamTest06 {

	public static void main(String[] args) {
//		int[] arr = {}; 
		int[] arr = new int[0];
//		int[] arr = null; //에러. null을 직접적으로 넣으면 안됨 
		System.out.println("arr.length="+arr.length);

//		Optional<String> opt = null; //ok. 하지만 바람직하지 않음.
		Optional<String> opt = Optional.empty();
//		Optional<String> opt = Optional.of("abc");
		System.out.println("opt="+opt);
//		System.out.println("opt="+opt.get()); //들어있는게 null이면 에러 발생, 잘 쓰지 않는다. 
		
		
		String str = "";
		//굳이 get을 써야한다면 
//		try {
//			str = opt.get();  //예외 발생하므로 블럭후 surround with 로  try/catch 잡아준다. 
//		} catch (Exception e) {
//			str = ""; //예외가 발생하면 빈문자열로 초기화 
//		}
		
		str = opt.orElse(""); //Optional에 저장된 값이 null이면 ""반환 
		str = opt.orElseGet(()->new String()); //람다 
		str = opt.orElseGet(String::new); //메서드 참조
		System.out.println("str="+str);
				
;	}

}
