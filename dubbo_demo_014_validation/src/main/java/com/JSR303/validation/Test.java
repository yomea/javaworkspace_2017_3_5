package com.JSR303.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Test {

	public static void main(String[] args) {

		User user = new User();

		user.setUsername("root");

		user.setPassword("youth");

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		
		for (ConstraintViolation<User> constraintViolation : violations) {
			System.out.println(constraintViolation);
		}
		
		
	}

}
