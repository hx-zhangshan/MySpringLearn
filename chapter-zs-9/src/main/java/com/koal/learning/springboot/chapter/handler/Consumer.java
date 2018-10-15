package com.koal.learning.springboot.chapter.handler;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者 
 * 消费消息队列
 * 
 * @author zhangS
 *
 * @date 2018年9月4日
 */
@Component
//监听 zhangS的消息队列
@RabbitListener(queues="zhangS")
@Slf4j
public class Consumer {

	//制定消息的处理方法
	@RabbitHandler
	public void process(String message) {
		log.info("接受到的消息是:{}",message);
	}
}
