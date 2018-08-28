package com.koal.learning.springboot.chapter;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.koal.learning.springboot.chapter.filter.HeController;
import com.koal.learning.springboot.chapter.filter.Myfilter;

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
 *   @warning 当启动多个 filter的时候注解并不能进行 顺序的控制 这时候有两张解决办法
 *    1；通过-过滤器的名字-进行顺序调用 比如LogFilter和AuthFilter，此时AuthFilter就会比LogFilter先执行，因为首字母A比L前面。
 *    2：通过注解@order 进行排序 数字越小跃先调用
 */

@SpringBootApplication
//  加入 这个注解 启动filter类 这个注解利用的是扫描webFilter  需要进行排序的话 只能用字母顺序来排序
@ServletComponentScan
@Slf4j
public class ChapterZs6Application {

	public static void main(String[] args) {
		SpringApplication.run(ChapterZs6Application.class, args);
		log.info("chapter6  服务启动");
	}
	/*
	 * 利用 启动类中利用@bean注册FilterRegistrationBean
	 * 的setOrder方法进行排序？
	 * 另一种添加过滤器的方法 这种增加了代码量但是排序顺序 比较明显
	 * 
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filter=new FilterRegistrationBean();
		
		
		//___________
		filter.setFilter(heFilter());
		filter.setName("heController");
		//设置过滤的路径
		filter.addUrlPatterns("/*");
		//设置过滤的顺序
		filter.setOrder(11);
		return filter;
	}
	@Bean
	public FilterRegistrationBean filterRegistrationBean2() {
		FilterRegistrationBean filter=new FilterRegistrationBean();
		
		filter.setFilter(myFilter());
		filter.setName("myfilter");
		//设置过滤的路径
		filter.addUrlPatterns("/*");
		//设置过滤的顺序
		filter.setOrder(10);
		
		return filter;
	}
	@Bean
	public Filter myFilter() {
		// TODO Auto-generated method stub
		return new Myfilter();
	}
	@Bean
	public Filter heFilter() {
		// TODO Auto-generated method stub
		return new HeController();
	}
}
