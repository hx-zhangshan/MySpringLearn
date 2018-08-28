package com.koal.learning.springboot.chapter.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author zhangS
 *
 * @date 2018年8月28日
 * 进行不同域的监听实现不同的 监听接口  servltetContenxt。HTTPListen，ServletRequestListener
 * 等 对这些域的监听和销毁，主要用于统计一些 在线人数等的业务操作
 * 同样适用servletComponentScan注解进行扫描
 */
@WebListener
@Slf4j
public class CustomLister implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		log.info("custom listen 销毁！！！！");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		log.info("custom listen 进行初始化！！！！");
	}

}
