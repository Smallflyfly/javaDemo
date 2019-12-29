package com.wochanye.demo.config.websocket;

import com.wochanye.demo.constant.CacheConsts;
import com.wochanye.demo.constant.ConfigConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


/**
 * 断开连接
 *
 * @author cuijie
 * @since 2018-07-26
 */


@Component
public class StompDisconnectEvent implements ApplicationListener<SessionDisconnectEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StompDisconnectEvent.class);

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        try {
            String sessionId = sha.getSessionAttributes().get(ConfigConsts.SESSION_ID) == null ? "" : sha.getSessionAttributes().get(ConfigConsts.SESSION_ID).toString();
            String wsSessionId = sha.getSessionId();
            String userId = sha.getSessionAttributes().get(ConfigConsts.SESSION_USER_ID) == null ? "" : sha.getSessionAttributes().get(ConfigConsts.SESSION_USER_ID).toString();
            sha.getSessionAttributes().remove(ConfigConsts.SESSION_ID);
            sha.getSessionAttributes().remove(ConfigConsts.SESSION_USER_ID);
            WebSocketCache.getCacheManager().remove(CacheConsts.WEB_SOCKET_USER + userId);
            logger.info(String.format("Stomp Disconnect Info -> sessionId: %s, wsSessionId: %s, userId: %s", sessionId, wsSessionId, userId));
        } catch (Exception e) {
            logger.error("Disconnect error -> ", e);
        }
    }

}
