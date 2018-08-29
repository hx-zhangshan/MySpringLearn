package com.koal.learning.springboot.chapter.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 制定注解的处理类
 * 
 * @author zhangS
 *
 * @date 2018年8月28日
 */
public class ConstantValid2Handler implements ConstraintValidator<ConstantValid, String> {

	private String constantValid;

	@Override
	public void initialize(ConstantValid constraintAnnotation) {
		// 获取到 设置的字段值
		this.constantValid = constraintAnnotation.value();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return constantValid.equals(value);
	}

}
