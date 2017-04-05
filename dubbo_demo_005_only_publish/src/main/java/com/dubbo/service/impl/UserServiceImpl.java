package com.dubbo.service.impl;

import com.dubbo.dao.UserDao;
import com.dubbo.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		
		this.dao = dao;
	}

	@Override
	public void sayHello() {
		System.out.println("hello world!!!");
		dao.sayHello();
	}

}
