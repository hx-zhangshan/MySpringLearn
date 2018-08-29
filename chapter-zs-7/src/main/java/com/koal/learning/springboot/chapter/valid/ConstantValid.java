package com.koal.learning.springboot.chapter.valid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
//指定注解的处理类
@Constraint(validatedBy=ConstantValid2Handler.class)
@Target(value = { ElementType.FIELD,ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstantValid {

	String message() default"{default constant!}";
	Class<?> [] groups() default{};
	Class<? extends Payload> [] payload() default{};
	String value();
}
