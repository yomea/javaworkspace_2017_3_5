package com.event.notice.service.impl;

import com.event.notice.entity.User;
import com.event.notice.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(int id) {
		
		return new User("root", "root");
	}

}
