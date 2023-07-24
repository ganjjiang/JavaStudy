import java.util.ArrayList;

public class GenericTest04 {

	public static class Fruit implements Eatable {
		public String toString() {
			return "Fruit";
		}
	}
	
	public static class Apple extends Fruit {
		public String toString() {
			return "Apple";
		}
	}
	
	public static class Grape extends Fruit {
		public String toString() {
			return "Grape";
		}
	}
	
	public static class Toy {
		public String toString() {
			return "Toy";
		}
	}
	
	interface Eatable {
		
	}
	
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape> grapeBox = new FruitBox<>();
		//FruitBox<Toy> toyBox = new FruitBox<>(); //에러. fruit의 자손이 아니기때문 
		Box<Toy> toyBox = new Box<Toy>(); //ok. Box클래스는 제약이 없음 

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		//appleBox.add(new Grape()); //에러. Apple 또는 Apple의 자손만 들어올수 잇음으로 
		
		
	}
	
	public static class FruitBox<T extends Fruit & Eatable> extends Box<T> {} //Fruit의 자식이면서 interface인 Eatable을 구현한 것만 들어올 수 있다. 
	//Eatable 꼭 필요 없음 어차피 구현했음으로 (implement가 아님 &임)
	
	public static class Box<T> {
		ArrayList<T> list = new ArrayList<T>(); //아이템을 저장할 리스트
		void add(T item) {list.add(item);} //박스에 아이템 추가하는 메소드  
		T get(int i) {return list.get(i);} //박스에서 아이템을 꺼내는 메소드 
		int size() {return list.size();}
		public String toString() {return list.toString();}
	}

}
