package learn.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {

	private Date timeStamp;
	private String message;
	private String errorDetails;

	public CustomErrorDetails(Date timeStamp, String message, String errorDetails) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

}
