import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest01 {

	public static void main(String[] args) {
	
		List<Integer> list = Arrays.asList(1,2,3,4,5); 
		//list를 stream객체로 생성 
		Stream<Integer> intStream = list.stream();

		intStream.forEach(System.out::print);
		//intStream.forEach(System.out::print); //에러. 스트림이 닫힘. 스트림을 다시 생성해야한다. 
		
		System.out.println();
//		Stream<String> strStream = Stream.of("a","b","c");
//		strStream.forEach(System.out::println);
		
		String[] strArr = new String[] {"a","b","c","d"};
		Stream<String> strStream = Stream.of(strArr);
		//Stream<String> strStream = Arrays.stream(strArr);
		//Stream<String> strStream = Stream.of(new String[] {"a","b","c","d"});
		strStream.forEach(System.out::println);
		
		
		//숫자 배열을 다룰 때는 기본형 steam을 다루면 연산도 가능하고 좋다. 
		int[] intArr = {1,2,3,4,5}; 
		IntStream intStream2 = Arrays.stream(intArr); //기본형 스트림 
//		intStream.forEach(System.out::println);
		//System.out.println("count="+intStream2.count()); 
		//System.out.println("sum="+intStream2.sum());
		System.out.println("average="+intStream2.average());
		
//		Integer[] intArr = {1,2,3,4,5}; //오토박싱 
//		Stream<Integer> intStream2 = Arrays.stream(intArr); 
//		//intStream2.forEach(System.out::println);
//		System.out.println("count="+intStream2.count()); //sum과 같은 연산은 안됨 
	}

}
