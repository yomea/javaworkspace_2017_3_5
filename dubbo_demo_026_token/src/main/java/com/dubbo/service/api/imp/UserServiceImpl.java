package com.dubbo.service.api.imp;

import com.dubbo.api.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public String sayHello(String name) {
		
		return name;
	}

}
