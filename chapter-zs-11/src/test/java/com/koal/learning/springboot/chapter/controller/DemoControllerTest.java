package com.koal.learning.springboot.chapter.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
//测试时候用的注解 可以指定特定的启动类或者测试环境 这里是默认
//测试是指定他是随机端口，避免不必要的端口冲突
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

//webMvctest 可以指定单一的接口，进行单一测试
//@WebMvcTest(value=DemoController.class)
public class DemoControllerTest extends BaseMockTest{

	// webMvcTest 时 用autoWried 是可以直接注入 mvcMock的

	@Test
	public void test() throws Exception {
		String msg = "this is mock test";
		//andDo（print）控制台会打印相关的 参数信息 利于 分析
		MvcResult andReturn = mockmvc.perform(get("/mock").param("msg", msg)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(msg, andReturn.getResponse().getContentAsString());
	}
}
