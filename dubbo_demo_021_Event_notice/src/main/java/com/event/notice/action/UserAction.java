package com.event.notice.action;

import com.event.notice.entity.User;
import com.event.notice.service.UserService;

public class UserAction {
	
	private UserService userService;
	
	
	
	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	public User getUser(int id) {
		return userService.getUser(id);
		
	}
	
	

}
