package com.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.service.UserService;

@Service(version="1.0.0")
public class UserServiceImpl implements UserService {

	@Override
	public void sayHello() {
		System.out.println("hello world!!!");

	}

}
