package member.model.vo;

public class MemberVo {
//	userID VARCHAR(20),
//	userPassword VARCHAR(20),
//	userName VARCHAR(20),
//	userEmail VARCHAR(50),
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userEmail;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "MemberVo [userID=" + userID + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + "]";
	}
	
	
	
}
