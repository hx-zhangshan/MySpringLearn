package com.koal.learning.springboot.chapter.controller;
/**
 *  建立mocktest基类 ，当需要进行多个测试的时候就不用
 *  每次都去 注入 mockMvctest  只需要集成此类 即可
 * @author zhangS
 *
 * @date 2018年10月16日
 */

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/**
 * @BeforeClass 加上这个注解，则该方法会第一个执行（在所有方法中），且方法要加上关键词static，是一个static方法
 * @AfterClass 加上这个注解，则该方法最后一个执行（在所有方法中）,同样，方法要加上关键词static，是一个static方法
 * 
 * contiPerf 是个轻量级的 测试工具，基于junit4 开发，可用于 效率测试
 *  制定 线程数和执行次数，通过限制最大通过时间和哦平均时间来进行 效率测试
 *  
 * @author zhangS
 *
 * @date 2018年10月16日
 */
public abstract class BaseMockTest {

	@Autowired
	private WebApplicationContext wc;
	
	protected MockMvc mockmvc;
	
	@Before
	public void beforeSetup() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
}
