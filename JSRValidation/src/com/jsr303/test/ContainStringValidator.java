package com.jsr303.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainStringValidator implements ConstraintValidator<ContainString, String> {

	private String containString;
	
	@Override
	public void initialize(ContainString containString) {
		
		this.containString = containString.containString();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null || !value.contains(containString)) {
			
			return false;
		}
		
		return true;
	}

}
