package inherit;

import java.util.List;
import java.util.ArrayList;

public class Hello {
	public static void main(String[] args) {
		List<Shape> ss = new ArrayList<>();
		ss.add(new Rectangle(3));
		ss.add(new Circle(3));
		ss.add(new Square());
		for(int i=0; i<10; ++i) {
			//ss.add(new Shape());
		}
		System.out.println(
			"Sum is: "+sumCir(ss)
		);
	}
	
	public static int sumCir(
			List<Shape> shapes
		) {
		int result = 0;
		for(Shape s: shapes) {
			result += s.getCir();
			result += s.getArea();
		}
		return result;
	}
}