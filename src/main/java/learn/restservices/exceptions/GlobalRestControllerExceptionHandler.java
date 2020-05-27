package learn.restservices.exceptions;

import java.util.Date;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {

	@ExceptionHandler(UserNameNotFoundException.class)
	protected CustomErrorDetails handleUserNameNotFoundException(UserNameNotFoundException ex, WebRequest request) {
		return new CustomErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	}
}
