import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionTest02 {

	public static void main(String[] args) {
		
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16); // 입력 : String 출력 :Integer => 16진수 해석 
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i); //입력 : Integer 출력 : String  => 2진수 해석 
		
		//두개의 함수를 하나로 결합해주는 함수 andThen() => f의 출력과 g의 입력의 타입이 같아야 합칠 수 있음. 
		Function<String, String> h = f.andThen(g); //f의 입력 : String g의 출력 : String 
		// f.compose(g) = g.andThen(f) => 둘 중 하나만 외우면 됨
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println(h.apply("FF")); // FF => 16진수로 해석 => 255 => 2진수로 해석 => "1111111" 
		System.out.println(h2.apply(2)); //그 반대 
		
		Function<String, String> f2 = x -> x; //항등 함수(identity function) 
		System.out.println(f2.apply("AAA")); //AAA 고대로 출력 
		
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 ==0;
		Predicate<Integer> notP = p.negate();  // p.negate = !p  // i >= 100  
		
		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150)); // i=150 -> T && T = True  
		
		String str1 = "abc";
		String str2 = new String("abc");  //true 단, == 비교는 false 
		
		//str1과 str2가 같은지 비교 
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);

	}

}
