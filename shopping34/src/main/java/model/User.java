package model;
import java.util.Date;
public class User {
	private String userId;
	private String userName;
	private String password;
	private String postCode;
	private String address;
	private String email;
	private String job;
	private Date birthday;
	
	public String getUserId() {	return userId;	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {	return userName;	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {	return password;	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPostCode() {	return postCode;	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {	return job;	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getBirthday() {	return birthday;	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}	
}