package com.dubbo.action;

import com.dubbo.service.UserService;

public class UserAction {
	
	private UserService service;
	
	public void sayHello() {
		
		service.sayHello();
	}
	
}
