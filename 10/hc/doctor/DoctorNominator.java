package hc.doctor;

import java.util.Map;
import java.util.HashMap;

public class DoctorNominator {
	
	private static final Map<Integer, Doctor>  REG_TO_DOCTOR = new HashMap<>();
	
	public static Doctor nominate(String name, int regNum) {
		checkRegnum(regNum);
		Doctor d = new Doctor(name, new Stamp(regNum));
		REG_TO_DOCTOR.put(regNum, d);
		return d;
	}
	
	public static ResearcherDoctor nominateResearcher (String name, int regNum) {
		checkRegnum(regNum);
		ResearcherDoctor d = new ResearcherDoctor(name, new Stamp(regNum));
		REG_TO_DOCTOR.put(regNum, d);
		return d;
	}
	
	private static void checkRegnum(int regNum) {
		if(REG_TO_DOCTOR.containsKey(regNum)) {
			throw new RegistrationNumberIsAlreadyTakenException(REG_TO_DOCTOR.get(regNum));
		}
	}
	
	
}