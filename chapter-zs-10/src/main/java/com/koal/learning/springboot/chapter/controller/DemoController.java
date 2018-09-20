package com.koal.learning.springboot.chapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zs")
public class DemoController {

	@GetMapping("/demo")
	public String demo() {
		
		return "hello world!!";
	}
}
