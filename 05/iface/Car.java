package iface;

public class Car implements Visitable {

	private final String regPlate;
	
	public Car(String regPlate) {
		this.regPlate=regPlate;
	}

    @Override
	public void visit() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "my registration plate is: "+regPlate;
	}
	
	@Override
	public boolean equals(Object param) {
		if(param == this) {
			return true;
		}
		if(param instanceof Car) {
			return this.regPlate.equals(
				((Car)param)
					.regPlate
			);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return regPlate.hashCode();
	}

}