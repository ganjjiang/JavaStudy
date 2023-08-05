import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTest01 {
	public static void main(String[] args) {
		
		Supplier<Integer> s = ()->(int)(Math.random()*100)+1; //1 ~ 100 난수 반환
		Consumer<Integer> c = i -> System.out.print(i+","); //콘솔 출력역할 
		Predicate<Integer> p = i -> i%2==0; //짝수인지 검사 
		Function<Integer, Integer> f = i -> i/10*10; //i의 일의 자리를 없앤다. 
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list); //list를 랜덤값으로 채운다 
		System.out.println("랜덤 수 : "+list); 
		printEvenNum(p,c,list); //짝수를 출력 
		List<Integer> newList = doSomething(f, list); // 일의 자리를 없앤다. 
		System.out.println("일의 자리 없애고 난 후 : "+newList); //최종 출력 

	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) { //일의 자리를 없애 새로운 리스트 반환 
		List<T> newList = new ArrayList<T>(list.size()); //출력을 위한 새로운 list 생성 
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		
		return newList; //일의 자리를 없애 새로운 리스트 반환 
	}
	
	// 짝수인지를 검사하는 P와 어떤 작업을 할지(출력)를 위한 c를 전달인자로 받는다. 
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print(" 짝수 : [");
		for(T i : list) {
			if(p.test(i)) //predicate안에 test람다식에 한번씩 다 돌려서 짝수인지를 판단한다. 
				c.accept(i); //짝수면 출력을 위한 Consumer에 넣는다. 
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) { //list에 10개 넣는다. 
		for(int i =0; i <10; i++) {
			list.add(s.get()); //supplier로부터 1 ~ 100의 난수를 받아서 list에 추가한다. 
		}
	}

}
