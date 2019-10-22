package iface;

public class Window implements Visitable, HasVisit {
	
	@Override
	public void visit() {
		System.out.println("Window");
	}
	
}