package com.gson.builder;

import java.io.Serializable;

public class GirlFriend  implements Serializable {
	
	private String name = "axiang";
	
	private Integer age = 22;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
