package com.koal.learning.springboot.chapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koal.learning.springboot.chapter.entry.DemoReq;
/**
 * 
 * @author zhangS
 *
 * @date 2018年8月28日
 */
@RestController
public class DemoController {

	@GetMapping(path="/demo")
	public String demo(DemoReq demoReq) {
		
		return "hello demo!!";
	}
}
