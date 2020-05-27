package learn.restservices.exceptions;

public class UserExistsException extends Exception {
	private static final long serialVersionUID = 4981440191606900054L;

	public UserExistsException(String message) {
		super(message);
	}
}
