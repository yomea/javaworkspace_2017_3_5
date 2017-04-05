package com.jsr303.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

@NotNull
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=RequiredValidator.class)
public @interface Required {
	
	String message() default "你必须填写数据";
	
	Class<?>[] groups() default { };//组别
	Class<? extends Payload>[] payload() default {};//负载
	

}
