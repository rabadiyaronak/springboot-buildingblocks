package learn.restservices.dtos;

public class UserMsDto {
	private Long userId;
	private String userName;
	private String emailAddress;

	public UserMsDto() {
	}

	public UserMsDto(Long id, String userName, String emailAddress) {
		super();
		this.userId = id;
		this.userName = userName;
		this.emailAddress = emailAddress;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
