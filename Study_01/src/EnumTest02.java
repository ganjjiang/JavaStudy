enum Direction2 {
	EAST(1, ">"), SOUTH(2,"v"),WEST(3,"<"),NORTH(4,"^"); //이렇게 값을 지정하려면 반드시 생성자가 필요하다. 
	
	private static final Direction2[] DIR_ARR = Direction2.values(); 
	private final int value; //각 상수들이 값을 두개를 갖기때문에 멤버변수도 두개를 선언한다. 
	private final String symbol;
	
	Direction2(int value, String symbol) { //생성자도 생성해야한다.
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() {return value;}
	public String getSymbol() {return symbol;} 
	
	public static Direction2 of(int dir) { //of : 상수들 중 하나를 얻어오기 위해 선언 
		if (dir < 1 || dir> 4) //0~3범위를 벗어나면 예외발생 
			throw new IllegalArgumentException("Invalid value : " + dir); 
		
		return DIR_ARR[dir - 1]; 
	}
	
	//방향을 회전시키는 메서드. num의 값만큼 90도씩 시계방향으로 회전한다. 
	public Direction2 rotate(int num) {
		num = num%4; //1~4까지 회전(4는 제자리) 
		
		if(num < 0 ) num += 4; //num이 음수일 때는 시계 반대방향으로 회전 
		
		return DIR_ARR[(value-1+num)%4];
	}
	
	public String toString() {
		return name()+getSymbol();
	}
}




public class EnumTest02 {
	public static void main(String[] args) {
		
		for(Direction2 d : Direction2.values()) //열거형 상수를 호출하면 모든 값을 반환 
			System.out.printf("%s=%d%n", d.name(), d.getValue()); //ordinal()은 인덱스값 반환 
		
		Direction2 d1 = Direction2.EAST;
		Direction2 d2 = Direction2.of(1);
		
		System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
		System.out.printf("d1=%s, %d%n", d2.name(), d2.getValue());
		System.out.println(Direction2.EAST.rotate(1)); //한번회전 
		System.out.println(Direction2.EAST.rotate(2)); //두번회전
		System.out.println(Direction2.EAST.rotate(-1)); //반시계
		System.out.println(Direction2.EAST.rotate(-2)); 
	}

}
