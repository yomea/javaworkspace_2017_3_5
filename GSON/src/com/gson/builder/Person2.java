package com.gson.builder;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

public class Person2 {
	
	@Since(value=2)
	private String username;
	@Until(value=5)
	private String password;
	
	public Person2() {
		
		
	}
	
	public Person2(String username, String password) {
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
