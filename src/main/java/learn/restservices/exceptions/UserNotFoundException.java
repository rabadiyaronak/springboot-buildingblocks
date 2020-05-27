package learn.restservices.exceptions;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -863173846058519960L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
