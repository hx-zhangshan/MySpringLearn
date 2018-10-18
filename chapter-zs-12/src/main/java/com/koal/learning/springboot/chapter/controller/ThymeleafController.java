package com.koal.learning.springboot.chapter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 是要返回 页面 所以这里不能用 @Rescontroller
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@GetMapping("/map")
	public String index(String name,ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("from", "zs.cn");
		//
		return "thymeleaf";
	}
	@GetMapping("/mv")
	public ModelAndView index(String name,ModelAndView mv) {
		mv.setViewName("thymeleaf");
		mv.addObject("name", name);
		mv.addObject("from", "zs.cn");
		//模板名称。全路径应该是src/mian/resources/templates/freemaker.html
		return mv;
	}
}
