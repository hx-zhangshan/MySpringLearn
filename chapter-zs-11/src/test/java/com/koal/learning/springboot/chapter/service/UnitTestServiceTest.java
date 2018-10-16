package com.koal.learning.springboot.chapter.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestServiceTest {

	@Autowired
	UnitTestService unitTestService;
	
	@Test
	public void test() {
		String msg="this is shabi.";
		String result = unitTestService.process(msg);
		assertEquals(msg, result);
	}

}
