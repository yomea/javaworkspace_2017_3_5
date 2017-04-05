package com.gson.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTestAnnotation2 {
	
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder()
				.setVersion(3)//大于@since序列化，小于@unit序列化
				.setPrettyPrinting()
				.create();
		
		Person2 person = new Person2("root","123");
		
		String str = gson.toJson(person);
		
		System.out.println(str);
		
	}

}
