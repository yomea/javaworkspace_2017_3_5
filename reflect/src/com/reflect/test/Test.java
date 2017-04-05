package com.reflect.test;

import java.lang.reflect.Field;

public class Test {

	public static void main(String[] args) {
		
		Class<?> clazz = Man.class;
		
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			System.out.println(field.getType());
		}
		
	}
	
}
