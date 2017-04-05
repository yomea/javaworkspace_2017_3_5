package com.dubbo.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserAction {
	
	@Reference(version="1.0.0")
	private UserService service;
	
	public void sayHello() {
		
		service.sayHello();
	}
	
}
