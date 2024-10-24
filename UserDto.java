package com.example.demo.sharedData;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 5108705696544023446L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userId;
	private String encrypetedPassword;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEncrypetedPassword() {
		return encrypetedPassword;
	}
	public void setEncrypetedPassword(String encrypetedPassword) {
		this.encrypetedPassword = encrypetedPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
