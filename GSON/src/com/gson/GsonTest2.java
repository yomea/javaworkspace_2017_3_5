package com.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gson.util.GsonUtil;
import com.gson.util.ParameterizedTypeImpl;

public class GsonTest2 {
	
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			
			users.add(new User(i, String.valueOf((char)('a' + 1)), "123"));
			
			
		}
		
		Gson gson = new Gson();
		
		String str = GsonUtil.toJson(users);
		
		System.out.println(str);
		
		//new TypeToken<List<User>>() {}由于TypeToken的构造器是protected的，所以需要继承调用
		List<User> us = gson.fromJson(str, new TypeToken<List<User>>() {}.getType());
		
		gson.fromJson(str, new ParameterizedTypeImpl(List.class, new Type[] {User.class}));
		
		System.out.println(new TypeToken<List<User>>() {}.getType());
		
		System.out.println(us.get(0).getUsername());
		
		
		
		
		
		
	}
	
	

}
