package com.gson.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gson.User;

public class GsonBuilderTest {
	
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder()
				//序列化null
		        .serializeNulls()
		        // 设置日期时间格式，另有2个重载方法
		        // 在序列化和反序化时均生效
		        .setDateFormat("yyyy-MM-dd")
		        // 禁此序列化内部类
		        .disableInnerClassSerialization()
		        //生成不可执行的Json（多了 )]}' 这4个字符）
		        .generateNonExecutableJson()
		        //禁止转义html标签
		        .disableHtmlEscaping()
		        //格式化输出
		        .setPrettyPrinting()
		        .create();
		
		User user = new User();
		
		String str = gson.toJson(user);
		
		System.out.println(str);
		
		
	}

}
