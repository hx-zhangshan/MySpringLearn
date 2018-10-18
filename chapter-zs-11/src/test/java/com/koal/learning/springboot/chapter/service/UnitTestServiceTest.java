package com.koal.learning.springboot.chapter.service;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
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
	//引入contiPerf 来测试性能
	@Rule
	public ContiPerfRule contiPerfRule=new ContiPerfRule();
	
	@Test
	//线程数10个，执行10次？invocations 调用durcation持续时间 不超过
	@PerfTest(threads=10,invocations=100)
	public void test() {
		String msg="this is shabi.";
		String result = unitTestService.process(msg);
		assertEquals(msg, result);
	}

}
