package com.koal.learning.springboot.chapter.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跨域请求 用@crossOrigin
 * @author zhangS
 *
 * @date 2018年10月19日
 */
@RestController
@CrossOrigin(origins = "http://blog.lqdev.cn", maxAge = 3600)
public class DemoController {

	@GetMapping("/")
	public String demo() {
		return "hello crossOrigin";
	}
}
