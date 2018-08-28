package com.koal.learning.springboot.chapter.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 通过继承WebMvcConfigurerAdapter 来注册自定义的拦截器
 * @author zhangS
 *
 * @date 2018年8月28日
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器和拦截规则
		//当进行 多拦截器的注册时候 执行的顺序就是添加的顺序 
		registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
	}
	@Bean
	public HandlerInterceptor getHandlerInterceptor() {
		
		return new CustomInterceptor();
	}
}
