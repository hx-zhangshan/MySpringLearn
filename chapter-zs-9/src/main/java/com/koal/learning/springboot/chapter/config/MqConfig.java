package com.koal.learning.springboot.chapter.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置一个 名字为zhangS的队列
 * @author zhangS
 *
 * @date 2018年9月4日
 */
@Configuration
//@EnableRabbit
public class MqConfig {

	@Bean
	public Queue zhangSqueue() {
		
		return new Queue("zhangS");
	}
}
