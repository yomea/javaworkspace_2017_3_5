package com.jsr303.test;

import javax.validation.constraints.Pattern;

public class Employee {
	
	@Pattern(regexp="\\w+")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
