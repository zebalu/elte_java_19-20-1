package inherit;

public class Circle extends Shape {

	private int radius = -1;
	
	public Circle(int r) {
		this.radius=r;
	}

	@Override
	public int getCir() {
		return 2*3*radius;
	}

}