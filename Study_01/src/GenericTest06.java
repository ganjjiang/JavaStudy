import java.util.ArrayList;


class Fruit3 implements Eatable2 {
	public String toString() {
		return "Fruit";
	}
}

class Apple3 extends Fruit3 {
	public String toString() {
		return "Apple";
	}
}

class Grape3 extends Fruit3 {
	public String toString() {
		return "Grape";
	}
}

class Toy2 {
	public String toString() {
		return "Toy";
	}
}

interface Eatable2 {}

public class GenericTest06 {
	public static void main(String[] args) {
		
//		//에러는 안나지만 원시타입과 지네릭타입을 섞어 쓰지마라 
//		Box v = new Box<String>();
//		v.add(new Integer(100)); //자동으로 지워짐 
//		
//		
//		Box b = null; 
//		Box<String> bStr = null; 
//		
//		b = (Box)bStr;   //Box<String> -> Box 가능 But 경고
//		bStr = (Box<String>)b ; //Box -> Box<String> 가능 But 경고 
//
//		
		
		FruitBox3<? extends Fruit3> fruitbox = new FruitBox3<Fruit3>();
		// FruitBox<Apple> -> FruitBox<? extends Fruit> 
		FruitBox3<? extends Fruit3> applebox = new FruitBox3<Apple3>();
		
		// FruitBox<? extends Fruit> -> FruitBox<Apple> 가능? 가능!!
		FruitBox3<Apple3> aBox = (FruitBox3<Apple3>)applebox; //ok. 경고발생 
		
	}

}

class FruitBox3<T extends Fruit3 & Eatable2> extends Box3<T> {} //Fruit의 자식이면서 interface인 Eatable을 구현한 것만 들어올 수 있다. 
//Eatable 꼭 필요 없음 어차피 구현했음으로 (implement가 아님 &임)

class Box3<T> {
	ArrayList<T> list = new ArrayList<T>(); //아이템을 저장할 리스트
	void add(T item) {list.add(item);} //박스에 아이템 추가하는 메소드  
	T get(int i) {return list.get(i);} //박스에서 아이템을 꺼내는 메소드 
	int size() {return list.size();}
	public String toString() {return list.toString();}
}
