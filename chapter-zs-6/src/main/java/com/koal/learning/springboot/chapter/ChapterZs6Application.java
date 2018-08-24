package com.koal.learning.springboot.chapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author zhangS
 *
 * @date 2018年8月24日
 *   本节内容 主要讲解是 web开发以及spring开发常用的一些注解
 *   
 *   当需要排除一些 不需要自动配置的启动类的时候就需要用exclude 去结合enableAutoConfigtion去排除
 *   
 *   过滤器的配置  在Servlet 3.0中加入了@webFilter的注解 直接通过注解进行过滤配置。
 */

@SpringBootApplication
//  加入 这个注解 启动filter类
@ServletComponentScan
@Slf4j
public class ChapterZs6Application {

	public static void main(String[] args) {
		SpringApplication.run(ChapterZs6Application.class, args);
		log.info("chapter6  服务启动");
	}
}
