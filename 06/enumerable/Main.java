package enumerable;

import java.util.List;
import java.util.ArrayList;

public class Main {
	
	private static int x = 0;
	private static int y = 0;

	public static void main(String[] args) {
		List<Direction> list = new ArrayList<>();
		list.add(Direction.NORTH);
		list.add(Direction.EAST);
		list.add(Direction.NORTH);
		list.add(Direction.NORTH_WEST);
		for(Direction d : list) {
			//move(d);
			smartMove(d);
		}
		System.out.println("final point: x="+x+", y="+y);
	}
	
	private static void move(Direction direction) {
		switch(direction) {
			case NORTH:
				y+=1;
				break;
			case SOUTH:
			    y-=1;
				break;
			case EAST:
			    x+=1;
				break;
			case WEST:
			    x-=1;
				break;
			default:
			    throw new IllegalArgumentException("Unknown direction: "+direction);
		}
	}
	
	private static void smartMove(Direction d) {
		x+=d.getX();
		y+=d.getY();
	}
	
	

}