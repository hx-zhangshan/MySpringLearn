package com.koal.learning.springboot.chapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping(value="/demo")
	public String demo() {
		return "hello filter!!";
	}
}
