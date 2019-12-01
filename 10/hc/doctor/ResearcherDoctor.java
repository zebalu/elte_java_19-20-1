package hc.doctor;

import hc.university.Researcher;
import hc.knowledge.Lexicon;

public class ResearcherDoctor extends Doctor implements Researcher {
	
	private int researchCounter = 0;
	
	public ResearcherDoctor(String name, Stamp stamp) {
		super(name, stamp);
	}
	
	@Override
	public String findCure(String illness) {
		if(Lexicon.hasCure(illness)) {
			return Lexicon.getCureFor(illness);
		}
		++researchCounter;
		String cure = "cure - "+this+" - "+researchCounter;
		Lexicon.registerCure(illness, cure);
		return cure;
	}
	
	@Override
	public boolean canCure(String illness) {
		return true;
	}
	
	@Override
	public String cure(String patient, String illness) {
		if(!super.canCure(illness)) {
			findCure(illness);
		}
		return super.cure(patient, illness);
	}
}