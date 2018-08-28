package com.koal.learning.springboot.chapter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lombok.extern.slf4j.Slf4j;

//@WebFilter(filterName="heController",urlPatterns="/*")
@Slf4j
//测试后发现 order 没有生效
//@Order(value=2)
public class HeController implements Filter{@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("he filter 初始化。。");
		
	}

    
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("he filter 开始调用过滤！！！");
		
		//继续下个调用
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("he filter 销毁。。");
		
	}

}
