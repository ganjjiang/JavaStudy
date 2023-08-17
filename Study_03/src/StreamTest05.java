import java.util.Arrays;
import java.util.stream.Stream;

import javax.print.DocFlavor.STRING;

public class StreamTest05 {

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc","def","jkl"},
				new String[] {"ABC", "GHI", "JKL"} 
				);
		
//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		//두개의 배열이 하나의 스트림으로 합쳐진다. 
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream); 
		
		strStrm.map(String::toLowerCase) //모두 소문자로 변경 
			.distinct() //중복 제거 
			.sorted() //정렬
			.forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
		};
				
		Stream<String> lineStream = Arrays.stream(lineArr); 
		lineStream.flatMap(line-> Stream.of(line.split(" +"))) //정규식 -> 하나 이상의 공백 표현 " +" 
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);

	}

}
