package com.gson.builder;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonCustomStrategy {
	
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder()
				.addSerializationExclusionStrategy(new ExclusionStrategy() {//还有好多其他的strategy
					
					@Override
					public boolean shouldSkipField(FieldAttributes f) {
						String name = f.getName();
					if(name.equals("age")) {
							
							return true;//表示不序列这个字段
						}
						return false;
					}
					
					@Override
					public boolean shouldSkipClass(Class<?> clazz) {
						
						System.out.println(clazz.getName());//com.gson.builder.GirlFriend
						return false;
					}
				}).serializeNulls().create();
		
		String jsonStr = gson.toJson(new GirlFriend());
		System.out.println(jsonStr);	
		
	}

}
