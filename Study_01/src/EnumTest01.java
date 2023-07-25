enum Direction {EAST, SOUTH, WEST, NORTH}


public class EnumTest01 {
	public static void main(String[] args) {
		
		//열거형 불러오는 방법 
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
		
		
		System.out.println("d1==d2 ? "+d1);

	}

}
