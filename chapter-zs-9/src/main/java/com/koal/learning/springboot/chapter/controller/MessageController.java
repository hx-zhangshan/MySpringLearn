package com.koal.learning.springboot.chapter.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 消息发送类
 * @author zhangS
 *
 * @date 2018年9月4日
 */
@RestController
public class MessageController {

	@Autowired
	AmqpTemplate rabbitMq;
	
	@GetMapping("/send")
	public String send(String msg) {
		rabbitMq.convertAndSend("zhangS", msg);
		return "消息"+","+msg+" 已经发送！";
	}
}
