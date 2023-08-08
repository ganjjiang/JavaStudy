import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest01 {

	public static void main(String[] args) {
	
		List<Integer> list = Arrays.asList(1,2,3,4,5); 
		//list를 stream객체로 생성 
		Stream<Integer> intStream = list.stream();

		intStream.forEach(System.out::print);
		//intStream.forEach(System.out::print); //에러. 스트림이 닫힘. 스트림을 다시 생성해야한다. 
		
	}

}
