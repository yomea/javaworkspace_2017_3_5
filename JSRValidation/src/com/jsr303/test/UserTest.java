package com.jsr303.test;

import java.awt.List;
import java.lang.annotation.Annotation;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class UserTest {

	public static void main(String[] args) {

		User user = new User();

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> set = validator.validate(user, GroupA.class);// 如果不写第二个参数就等价于validator.validate(user,Default.class)，将会验证此类和它的父类的字段;第二个参数表示组别
		for (ConstraintViolation<User> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}

		Annotation[] annotations = ContainString.class.getDeclaredAnnotations();

		for (Annotation annotation : annotations) {
			System.out.println(annotation);
			/**
			 * @java.lang.annotation.Target(value=[FIELD]) @java.lang.annotation.Retention(value=RUNTIME) @java.lang.annotation.Documented()
			 * jsr303是通过Constraint这个注解找到要验证的应用程序
			 * 
			 * @javax.validation.Constraint(validatedBy=[class com.jsr303.test.ContainStringValidator])
			 */
		}

	}

}
