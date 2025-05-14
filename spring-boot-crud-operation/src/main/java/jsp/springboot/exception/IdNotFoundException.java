package jsp.springboot.exception;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "ID not available in DB";
	}

}
