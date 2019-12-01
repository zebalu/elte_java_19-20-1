package hc.doctor;

import hc.knowledge.Lexicon;

public class Doctor {
	
	private final String name;
	private final Stamp stamp;
	
	protected Doctor(String name, Stamp stamp) {
		this.name=name;
		this.stamp=stamp;
	}
	
	@Override
	public String toString() {
		return name+" "+stamp;
	}
	
	public boolean canCure(String illness) {
		return Lexicon.hasCure(illness);
	}
	
	public String cure(String patient, String illness) {
		if(canCure(illness)) {			
			return patient+
				" should take: "+
				Lexicon.getCureFor(illness)+
				"\nsign: "+
				name+
				"\nstamp: "+
				stamp;
		} else {
			return Lexicon.getCureFor(illness);
		}
	}
	
}