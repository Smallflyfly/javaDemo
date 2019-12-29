package com.wochanye.demo.config.websocket;

import com.wochanye.demo.constant.CacheConsts;
import com.wochanye.demo.constant.ConfigConsts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * 连接初始建立
 *
 * @author cuijie
 * @since 2018-07-26
 */
@Component
public class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {

    private static final Logger logger = LoggerFactory.getLogger(StompConnectEvent.class);

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());
        try {
            String sessionId = sha.getSessionAttributes().get(ConfigConsts.SESSION_ID) == null ? "" : sha.getSessionAttributes().get(ConfigConsts.SESSION_ID).toString();
            String wsSessionId = sha.getSessionId();
//            String wsSessionId = sessionConnectEvent.getUser().getName(); shiro 或 security 可以获取到
            String userId = sha.getSessionAttributes().get(ConfigConsts.SESSION_USER_ID) == null ? "" : sha.getSessionAttributes().get(ConfigConsts.SESSION_USER_ID).toString();
            // 若多个浏览器登录，直接覆盖，可以视具体需求定
            if (StringUtils.isNoneBlank(userId)) {
                WebSocketCache.getCacheManager().put(CacheConsts.WEB_SOCKET_USER + userId, wsSessionId);
            }
            logger.info(String.format("Stomp Connect Info -> sessionId: %s, wsSessionId: %s, userId: %s", sessionId, wsSessionId, userId));
        } catch (Exception e) {
            logger.error("web socket connect error -> ", e);
        }
    }

}
