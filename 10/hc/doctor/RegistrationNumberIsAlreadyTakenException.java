package hc.doctor;

public class RegistrationNumberIsAlreadyTakenException extends RuntimeException {

    public RegistrationNumberIsAlreadyTakenException(Doctor doctor) {
		super("Registration number is already taken by: "+doctor);
    }

}