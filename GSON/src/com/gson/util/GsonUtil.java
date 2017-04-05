package com.gson.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.gson.result.Result;

public class GsonUtil {

	public static final Gson GSON = new Gson();

	public static <T> Result<T> fromJsonObject(String jsonStr, Class<?> clazz, Class<?> beanClass) {

		Type type_1 = new ParameterizedTypeImpl(clazz, new Class[] { beanClass });

		Type type = new ParameterizedTypeImpl(Result.class, new Type[] { type_1 });
		return GSON.fromJson(jsonStr, type);
	}

	public static <T> Result<T> fromJsonObject(String jsonStr, Class<?> clazz) {
		
		return GSON.fromJson(jsonStr, new ParameterizedTypeImpl(Result.class, new Type[] { clazz }));
	}
	
	public static String toJson(Object obj) {
		
		return GSON.toJson(obj);
	}

	/**
	 * 
	 * @param jsonStr
	 * @param classStr
	 *            处理简单的集合字符串如：List<User> 这种Map<Set<String>,
	 *            List<User>>谁的json会搞成这样
	 * @return Result<T>
	 */
	public static <T> Result<T> fromJsonObject(String jsonStr, String classStr) {

		return null;
	}

}
