package com.wochanye.demo.config.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 存放
 *
 * @author cuijie
 * @since 2018-07-26
 */
public class WebSocketCache {

    private static Map<String, String> cacheManager = new ConcurrentHashMap<>();

    public static Map<String, String> getCacheManager() {
        return cacheManager;
    }
}
