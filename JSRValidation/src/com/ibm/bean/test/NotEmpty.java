package com.ibm.bean.test;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NotEmptyValidator.class})

public @interface NotEmpty {
	String message() default "this string may be empty";//验证出错时的提示信息
	Class<?>[] groups() default { };//组别
	Class<? extends Payload>[] payload() default {};//负载
	
	@Target({ METHOD, FIELD, ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@interface List {
		NotEmpty[] value();
	}
}
