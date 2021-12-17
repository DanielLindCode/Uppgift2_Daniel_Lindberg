package model;



public class userBean {

	private String password;
	private String userName;
	private String userNumber;
	
	//Constructor	
	public userBean(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	
}
