package com.koal.learning.springboot.chapter.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;
import javax.websocket.RemoteEndpoint.Async;

public class webScokerUtil {

	private static final Map<String, Session> ONLINE_SESSION=new ConcurrentHashMap<>();
	
	public static void addSession(String usernick, Session session) {
		//简单的用 map 保存session
		
		ONLINE_SESSION.put(usernick, session);
	}

	public static void removeSession(String usernick) {

		if (ONLINE_SESSION.get(usernick)!=null) {
			ONLINE_SESSION.remove(usernick);
		}
	}
	/**
     * 向某个用户发送消息
     * @param session 某一用户的session对象
     * @param message
     */
    public static void sendMessage(Session session, String message) {
        if(session == null) {
            return;
        }
        // getAsyncRemote()和getBasicRemote()异步与同步
        Async async = session.getAsyncRemote();
        //发送消息
        async.sendText(message);
    }

	public static void sendMessageForall(String message) {
		ONLINE_SESSION.forEach((sessionId,session)->sendMessage(session, message));
	}
}
