package com.koal.learning.springboot.chapter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebJarsController {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
}
