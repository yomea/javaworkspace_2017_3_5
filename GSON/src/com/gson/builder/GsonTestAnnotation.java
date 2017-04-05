package com.gson.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTestAnnotation {
	
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()//排除没有被@Expose注解修饰的字段
				.setPrettyPrinting()
				.create();
		
		Person person = new Person("root","123");
		
		String str = gson.toJson(person);
		
		System.out.println(str);
		
	}

}
