package com.jsr303.test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, String> {

	
	@Override
	public void initialize(Required arg0) {
		
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		if(arg0 == null || arg0.equals("")) return false;
		
		return true;
	}

}
