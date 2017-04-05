package com.jsr303.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=ContainStringValidator.class)
public @interface ContainString {
	
	String containString() default "";
	
	String message() default "您的字符串中必须包含指定的字符串";
	
	Class<?>[] groups() default { };//组别
	Class<? extends Payload>[] payload() default {};//负载
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@interface More {
		
		ContainString[] value();
	}
	
	

}
