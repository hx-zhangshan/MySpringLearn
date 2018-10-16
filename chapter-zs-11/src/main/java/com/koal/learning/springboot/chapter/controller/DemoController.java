package com.koal.learning.springboot.chapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author zhangS
 *
 * @date 2018年10月15日
 */
@RestController
public class DemoController {

	@GetMapping("/mock")
	public String demo(String msg) {
		
		
		return msg;
	}
}
