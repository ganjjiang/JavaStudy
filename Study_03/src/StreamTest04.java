import java.io.File;
import java.util.stream.Stream;

public class StreamTest04 {

	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
					new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
				};
		
		//파일객체들을 스트림으로 변경 
		Stream<File> fileStream = Stream.of(fileArr);
		
		//map()으로 Stream<File>을 Stream<String>으로 변환 
		Stream<String> filenameStream = fileStream.map(File::getName); //(f)->f.getName() 파일객체를 전달하면 파일 이름만을 반환 
		filenameStream.forEach(System.out::println); // 모든 파일의 이름을 출력 
		
		fileStream = Stream.of(fileArr); 
		
		fileStream.map(File::getName)
			.filter(s->s.indexOf('.') != -1) //확장자가 없는 것은 제외
			.peek(s->System.out.printf("filename=%s%n", s)) //중간중간 확인하기 
			.map(s->s.substring(s.indexOf('.')+1)) //확장자만 추출
			.peek(s->System.out.printf("extension=%s%n", s))
			.map(String::toUpperCase) //추출한 확장자 모두 대문자로 
			.distinct() //중복제거 
			.forEach(System.out::print); //출력 
		
		System.out.println();
		}

	}


