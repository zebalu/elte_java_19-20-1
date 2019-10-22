package inherit;

public abstract class Shape {
	
	public Shape() {
		printMessage();
	}
	
	public abstract int getCir();
	
	public final int getArea() {
		return 42;
	}
	
	protected void printMessage() {
		System.out.println("new shape was created: "
			+ this.getClass().getSimpleName()
		);
	}
	
}