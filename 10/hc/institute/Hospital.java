package hc.institute;

import java.util.List;
import java.util.ArrayList;

import hc.doctor.Doctor;

public class Hospital <T extends Doctor> {
	
	private List<T> doctors = new ArrayList<>();
	
	public void addDoctor(T doctor) {
		doctors.add(doctor);
	}
	
	public boolean cure(String patient, String illness) {
		for(T d: doctors) {
			if(d.canCure(illness)) {
				d.cure(patient, illness);
				return true;
			}
		}
		return false;
	}
	
}