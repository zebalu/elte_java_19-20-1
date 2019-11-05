package exceptions;

public class MyRuntimeException extends RuntimeException {
	
	public MyRuntimeException() {
		this(null, null);
	}
	
	public MyRuntimeException(String message) {
		this(message, null);
		//super("Error because of: "+message);
	}
	
	public MyRuntimeException(Throwable t) {
		this(null, t);
	}
	
	public MyRuntimeException(String message, Throwable cause) {
		super("Error because of: "+message, cause);
	}
}