import java.util.ArrayList;

public class GenericTest05 {
	
	public static class Fruit2  {
		public String toString() {
			return "Fruit";
		}
	}
	
	public static class Apple2 extends Fruit2 {
		public String toString() {
			return "Apple";
		}
	}
	
	public static class Grape2 extends Fruit2 {
		public String toString() {
			return "Grape";
		}
	}
	
	public static class Juice {
		String name; 
		
		Juice(String name) {
			this.name = name + "Juice"; 
		}
		
		public String toString() {
			return name; 
		}
		
	}
	
	public static class Juicer {
		static Juice makeJuice(FruitBox2 <? extends Fruit2> box) {
			String tmp = "";
			for(Fruit2 f : box.getList())
				tmp += f + " "; 
			return new Juice(tmp);
		}
	}

	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		//FruitBox2<Fruit2> appleBox = new FruitBox2<Apple2>(); //에러. 
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
		
		fruitBox.add(new Apple2());
		fruitBox.add(new Grape2());
		appleBox.add(new Apple2());
		appleBox.add(new Apple2());
		
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		
//		FruitBox2<? extends Fruit2> appleBox = new FruitBox2<Apple2>(); //ok. Fruit2와 그의 자손들을 모두 참조할 수 있다. 
//		appleBox = new FruitBox2<Fruit2>();
//		appleBox = new FruitBox2<Apple2>();
//		appleBox = new FruitBox2<Grape2>();

	}

	
	public static class FruitBox2<T extends Fruit2> extends Box2<T> {} 
	
	public static class Box2<T> {
		
		ArrayList<T> list = new ArrayList<T>(); //아이템을 저장할 리스트
		void add(T item) {list.add(item);} //박스에 아이템 추가하는 메소드  
		T get(int i) {return list.get(i);} //박스에서 아이템을 꺼내는 메소드 
		ArrayList<T> getList() {return list;}
		int size() {return list.size();}
		public String toString() {return list.toString();}
	}
}
