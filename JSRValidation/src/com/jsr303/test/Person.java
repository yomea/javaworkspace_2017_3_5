package com.jsr303.test;

import javax.validation.constraints.Min;

public interface Person {
	
	@Min(10)
	public int getAge();

	public void setAge(int age);

}
