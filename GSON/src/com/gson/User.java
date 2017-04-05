package com.gson;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class User implements Serializable {
	
	private static final long serialVersionUID = -2027376124473257182L;

	private Integer id;
	
	@SerializedName("name")
	private String username;
	//{"id":1,"name":"root","密码":"123"}alternate表示反序列化时的替代字段，它看到密码两个字，就会到@SerializedName的alternate中找，找到就转换成对应的字段
	@SerializedName(value="password", alternate={"p", "密码"})
	private String password;

	public User() {
		
	}
	
	
	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	

}
