package com.koal.learning.springboot.chapter.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * @controllerAdcice 控制器增强 使用@exceptionHandler @initBinder
 * 
 * @author zhangS
 *
 * @date 2018年8月28日
 * @description 自定义异常类
 */
@RestControllerAdvice
@Slf4j
public class CommonsExceptionHandler {

	//使用 jsr303校验的时候产生的 异常？
	@ExceptionHandler(BindException.class)
	public Map<String, Object> exceptionHandler(BindException ex) {
		log.info("commonsException:{}({})", "控制校验", "10000");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "9999");
		result.put("respMsg", ex.getMessage());

		return result;
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> exceptionHandler(MethodArgumentNotValidException ex) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "9999");
		result.put("respMsg", ex.getMessage());

		return result;
	}
	@ExceptionHandler(CommonsException.class)
	public Map<String, Object> exceptionHandler(CommonsException ex) {
		log.info("commonsException:{}({})", ex.getResCode(), ex.getResMsg());

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", ex.getResCode());
		result.put("respMsg", ex.getResMsg());

		return result;
	}
}
