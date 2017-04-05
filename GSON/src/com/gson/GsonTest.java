package com.gson;

import com.google.gson.Gson;

public class GsonTest {
	
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		User user = new User(1, "root", "123");
		
		String str = gson.toJson(user);
		
		System.out.println(str);
		
		User u = gson.fromJson(str, User.class);
		
		System.out.println(u);
		
		
		
	}
	
	

}
