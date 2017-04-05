package com.jsr303.test;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.ibm.bean.test.Group;

public class User implements Person {
	
	@Size(min=3, groups=Group.class)
	//自动循环验证
	@ContainString.More(value={@ContainString(containString="java"), @ContainString(containString="jsp")})
	//@ContainString(containString="java")
	private String username="java sp";
	
	@Required
	private String password;
	
	@Valid//级联验证，否则不被验证
	private Employee employee;
	
	
	private int age;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	public int getAge() {
		return age;
	}
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
