package com.koal.learning.springboot.chapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * webSocket 服务端简单应用。
 * 
 * @author zhangS
 *
 * @date 2019年1月24日
 */
@SpringBootApplication
@EnableWebSocket
public class ChapterZs13Application {

	public static void main(String[] args) {
		SpringApplication.run(ChapterZs13Application.class, args);
	}
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
