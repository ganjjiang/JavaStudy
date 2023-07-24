import java.util.HashMap;

public class GenericTest03 {

	public static void main(String[] args) {
		
		HashMap<String, Student> map = new HashMap<>(); // 생성자에는 타입 생략 가능 
		
		map.put("자바왕", new Student("자바왕",1,1,100,100,100));
		
		Student s = map.get("자바왕");//형변환 필요없이 담을 수 있다. 
		
	    System.out.println(map);
		
		
	}

	
	public static class Student {
		String name = "";
		int ban;
		int no;
		int kor;
		int eng;
		int math; 
		
		Student(String name, int ban, int no, int kor, int eng, int math){
			this.name = name;
			this.ban = ban;
			this.no = no; 
			this.kor = kor;
			this.eng = eng;
			this.math = math; 
		}
	}
}
