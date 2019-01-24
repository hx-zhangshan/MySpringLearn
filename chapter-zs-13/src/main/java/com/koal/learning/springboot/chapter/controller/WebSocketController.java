package com.koal.learning.springboot.chapter.controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.koal.learning.springboot.chapter.util.webScokerUtil;

import lombok.extern.slf4j.Slf4j;
/**
 * @serverEndpoint 类似于 resController的  指定 一个
 *  访问的路径、
 * @author zhangS
 *
 * @date 2018年10月24日
 */
@Slf4j
@Component
@ServerEndpoint(value = "/my-chat/{usernick}")
public class WebSocketController {

	@OnOpen
	public void onOpen(@PathParam(value="usernick") String usernick,Session session) {
		String message="欢迎{ "+usernick+"}进入聊天室！";
		log.info(message);
		webScokerUtil.addSession(usernick,session);
		webScokerUtil.sendMessageForall(message);
	}
	@OnClose
	public void onClose(@PathParam(value="usernick") String usernick,Session session) {
		String message="{ "+usernick+"}离开聊天室！";
		log.info(message);
		webScokerUtil.removeSession(usernick);
		webScokerUtil.sendMessageForall(message);
	}
	@OnMessage
	public void OnMessage(@PathParam(value="usernick") String usernick,String message) {
		String info="游客：{ "+usernick+"}：：："+message;
		log.info(info);
		webScokerUtil.sendMessageForall(info);
	}
}
