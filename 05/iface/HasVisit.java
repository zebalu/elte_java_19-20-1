package iface;

public interface HasVisit {
	
	
	default void visit() {
		System.out.println("This is the other visit");
	}
	
}