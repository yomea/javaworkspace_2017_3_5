package com.dubbo.service.action;

import com.dubbo.service.UserService;

public class UserAction {
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		
		this.userService = userService;
	}
	
	public void sayHello() {
		
		userService.sayHello("");
	}

}
