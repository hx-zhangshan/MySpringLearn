package com.koal.learning.springboot.chapterzs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author zs 
 * @ResController=@controller+@requestBody 直接就返回Json
 */
@RestController
public class DemoController {

	@RequestMapping(value="/demo",method=RequestMethod.GET)
	public String demo() {
		return "hello SpringBoot!";
	}
}
