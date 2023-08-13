import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest02 {

	public static void main(String[] args) {
////		IntStream intStream = new Random().ints();
////		IntStream intStream = new Random().ints(5); //limt말고도 개수 지정 가능 
//		IntStream intStream = new Random().ints(5, 10); //범위 지정 5부터 9까지 
//		intStream
//		.limit(5) //무한 난수 스트림이라서 limt로 개수를 자르지 않으면 무한으로 난수를 생성한다. 
//		.forEach(System.out::println); 

		//iterate(T seed, UnaryOperator f)  단항 연산자 
		Stream<Integer> intStream = Stream.iterate(1,  n -> n+2);
		intStream.limit(10).forEach(System.out::println);
		
		//generate(Supplier s) : 주기만 하는 것, 입력x, 출력o 
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(10).forEach(System.out::println);
	}

}
