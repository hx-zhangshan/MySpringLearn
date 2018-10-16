package com.koal.learning.springboot.chapter.service.impl;

import org.springframework.stereotype.Service;

import com.koal.learning.springboot.chapter.service.UnitTestService;

/**
 * 实现类
 * @author zhangS
 *
 * @date 2018年10月15日
 */
@Service
public class UnitTestServiceImpl implements UnitTestService{

	@Override
	public String process(String msg) {
		
		return msg;
	}

	//为了测试直接返回输入值
	
}
