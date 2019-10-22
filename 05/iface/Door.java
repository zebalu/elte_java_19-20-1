package iface;

public class Door implements Visitable, HasVisit {

	@Override
	public void visit() {
		System.out.println("This is a door");
	}

}