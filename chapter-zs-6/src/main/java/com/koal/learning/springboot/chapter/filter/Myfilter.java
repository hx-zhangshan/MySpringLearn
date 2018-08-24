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
/**
 * 
 * @author zhangS
 *
 * @date 2018年8月24日
 * 注册器名称是myfilter 拦截URL为 所有
 */
@WebFilter(filterName="myfilter",urlPatterns="/*")
@Slf4j
public class Myfilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("filter 初始化！！！");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info(" dofilter 开始处理请求");
		
		//对 request response 进行一些预处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// TODO 一些业务逻辑
		
		//链路 传递给下一个 过滤器使用
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("filter 销毁！！！");
		
	}

	
}
