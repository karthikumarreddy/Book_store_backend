package com.bookstore.dto;

import java.sql.Timestamp;

public class UsersDTO {
	private String fullName;
	private String password;
	private String email;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean is_active;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public UsersDTO(String fullName, String password, String email, Timestamp created_at, Timestamp updated_at, boolean is_active) {
		super();
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.is_active = is_active;
	}
	public UsersDTO() {
		super();
	}
	
	

}
