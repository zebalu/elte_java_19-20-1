package inherit;

public class Rectangle 
    extends Shape {
	
	private int side = -1;
	
	public Rectangle(int side) {
		this.side=side;
	}
	
	public int getCir() {
		return side * 4;
	}
	
	protected void printMessage() {
		System.out.println("barmi");
	}
}