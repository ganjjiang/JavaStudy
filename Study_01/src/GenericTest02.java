import java.util.ArrayList;
import java.util.List;

public class GenericTest02 {

	public static class Product {} 
	public static class Tv extends Product {} 
	public static class Audio extends Product {} 
	
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		//ArrayList<Product> productList = new ArrayList<Tv>(); //에러 
		List<Tv> tvList2 = new ArrayList<Tv>(); //ok. 다형성은 인정 (타입은 같아야함) 
		
		productList.add(new Tv()); // public boolean add(Product e) //product의 자손 모두 ok. => 다형성 
		
		tvList.add(new Tv()); //public boolean add(Tv e)
		//tvList.add(new Audio());//에러. Audio는 Tv의 자손이 아니므로 안됨. 
		
		printAll(productList);
		//printAll(tvList);  //에러. 타입이 다르므로 

	}
	
	public static void printAll(ArrayList<Product> list) {
		for (Product p : list)
			System.out.println(p);
	}

}
