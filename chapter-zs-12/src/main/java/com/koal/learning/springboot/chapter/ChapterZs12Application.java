package com.koal.learning.springboot.chapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
/**
 * 
 * @author zhangS
 *
 * @date 2018年10月18日
 * exclude 不让MultipartAutoConfiguration 自动启动
 */
@SpringBootApplication(exclude= {MultipartAutoConfiguration.class})
public class ChapterZs12Application {

	public static void main(String[] args) {
		SpringApplication.run(ChapterZs12Application.class, args);
	}
}
