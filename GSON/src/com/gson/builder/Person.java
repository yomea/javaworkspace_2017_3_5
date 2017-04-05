package com.gson.builder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {
	
	@Expose
	@SerializedName("name")
	private String username;
	
	private String password;
	
	public Person() {
		
		
	}
	
	public Person(String username, String password) {
		this.username = username;
		
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
