package com.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * java.util.List<E>序号为：1 的<>内的参数类型
 * TypeVariable is E
 * java.util.List<java.lang.String>序号为：2 的<>内的参数类型
 * Class is java.lang.String
 * java.util.List<? extends java.lang.Number>序号为：3 的<>内的参数类型
 * WildcardType is ? extends java.lang.Number 
 * java.util.List<java.util.Map<java.lang.String,java.lang.String>>序号为：4 的<>内的参数类型
 * ParameterizedType is java.util.Map<java.lang.String, java.lang.String> 
 * java.util.List<java.lang.Integer[]>序号为：5 的<>内的参数类型
 * Class is java.lang.Integer[] 
 * com.type.Result<java.lang.String>序号为：7 的<>内的参数类型
 * Class is java.lang.String 
 * java.util.List<java.util.List<E>[]>序号为：9 的<>内的参数类型
 * GenericArrayType is java.util.List<E>[]
 * java.util.List<java.util.List>序号为：10 的<>内的参数类型
 * Class is java.util.List
 * java.util.List<E[]>序号为：12的<>内的参数类型
 * GenericArrayType is E[]
 * 
 * @author may
 *
 */
public class Test {

	public <E> E test(List<E> e, List<String> str, List<? extends Number> num, List<Map<String, String>> param,
			List<Integer[]> integer, String s, Result<String> result, Result r, List<List<E>[]> ga, List<List> l, E[] ee/*E[] 为GenericArrayType*/, List<E[]> le) {
		return null;

	}

	public static void main(String[] args) {
		//获得所有定义的方法
		Method[] methods = Test.class.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().contains("main") || method.getName().contains("print"))
				continue;
			Type[] paramTypes = method.getGenericParameterTypes();
			System.out.println(paramTypes.length);// 总共12个参数
			int count = 0;
			for (Type paramType : paramTypes) {
				count++;

				// 有<>泛型修饰就是被泛型化的数组
				if (paramType instanceof ParameterizedType) {

					System.out.println(paramType + "序号为：" + count + "的<>内的参数类型");

					Type[] types = ((ParameterizedType) paramType).getActualTypeArguments();

					for (Type type : types) {

						print(type);

					}

				}

			}
		}

	}
	
	private static void print(Type type) {
		
		if (type instanceof ParameterizedType) {

			System.out.println("ParameterizedType is " + type.getTypeName());
		} else if (type instanceof TypeVariable) {

			System.out.println("TypeVariable is " + type.getTypeName());
		} else if (type instanceof GenericArrayType) {
			System.out.println("GenericArrayType is " + type.getTypeName());
		} else if (type instanceof WildcardType) {
			System.out.println("WildcardType is " + type.getTypeName());
		} else {

			System.out.println("Class is " + type.getTypeName());
		}
	}

}
