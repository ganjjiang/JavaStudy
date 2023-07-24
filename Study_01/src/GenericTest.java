import java.util.ArrayList;

public class GenericTest {
	
	public static class Tv {}
	
	public static class Audio {}	

	public static void main(String[] args) {
		//ArrayList list = new ArrayList();
		ArrayList<Tv> list = new ArrayList<Tv>();
		
		list.add(new Tv());
		//list.add(new Audio()); //Tv객체만 저장가능하므로 에러 
		
		//Tv t = (Tv)list.get(0); //list의 첫번째 요소를 꺼낸다. 
		Tv t = list.get(0); //별도의 형변환이 필요없다. 
	}

}
