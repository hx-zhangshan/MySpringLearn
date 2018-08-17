package com.koal.learning.springboot.chapterzs.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koal.learning.springboot.chapterzs.config.Config;

import lombok.extern.log4j.Log4j;
/**
 * 
 * @author zs 
 * @ResController=@controller+@requestBody 直接就返回Json
 */
@Log4j
@RestController
public class DemoController {

	
	@Resource
	private Config config;
	@RequestMapping(value="/demo",method=RequestMethod.GET)
	public String demo() {
		System.out.println(config.toString());
		log.error(config.toString());
		return "hello SpringBoot!"+config.getName();
	}
}
