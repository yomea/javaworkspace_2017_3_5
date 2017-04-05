package com.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.gson.result.Result;
import com.gson.util.GsonUtil;

public class GsonTest3 {
	
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			
			users.add(new User(i, String.valueOf((char)('a' + 1)), "123"));
			
			
		}
		
		Result<List<User>> result = new Result<List<User>>("success", "运行成功！！！", users);
		
		Gson gson = new Gson();
		
		String str = gson.toJson(result);
		
		System.out.println(str);
		
		// Type t = new ParameterizedTypeImpl(List.class, new Type[]{User.class});
		
		Result<List<User>> us = GsonUtil.fromJsonObject(str, List.class, User.class);
		
		System.out.println(us);
		
		
		
		
		
		
		
	}

	

}
