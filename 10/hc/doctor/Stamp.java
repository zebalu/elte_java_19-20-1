package hc.doctor;

public class Stamp {
	
	private final int registrationNumber;
	
	Stamp(int registrationNumber) {
		this.registrationNumber=registrationNumber;
	}
	
	@Override
	public String toString() {
		return "rn: "+registrationNumber;
	}
	
}