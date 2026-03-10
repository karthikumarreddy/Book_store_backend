package com.bookstore.dto;

public class LoginDTO {
	private String userName;
	private String email;
	private int mobile_number;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDTO(String userName, String email, int mobile_number, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobile_number = mobile_number;
		this.password = password;
	}
	
	
	 

}
