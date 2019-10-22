package iface;

public interface Visitable {
	
	//public abstract void visit();
	default void visit() {
		System.out.println("This is visitable");
	}
	
}