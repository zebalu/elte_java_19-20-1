package inherit;

public class Square extends Rectangle {
	
	public Square() {
		super(12);
	}
	
	protected void printMessage() {
		System.out.println("it is good to be a square");
	}
	
}