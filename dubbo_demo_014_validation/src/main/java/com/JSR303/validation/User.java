package com.JSR303.validation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	@NotNull
	private String username;
	
	@NotNull
	@Size(min=10, max=20, message="个数必须在10到20之间")
	private String password;
	
	public void setAge(@Min(10) int age) {
		
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
