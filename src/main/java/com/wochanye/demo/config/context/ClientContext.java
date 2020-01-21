package com.wochanye.demo.config.context;

/**
 * @author fangpf
 * @date 2020/1/20 16:15
 */
public class ClientContext {
    private static final ThreadLocal<ClientInfo> clientInfo = new ThreadLocal<>();

    public ClientContext() {
    }

    public static ThreadLocal<ClientInfo> getClientInfo() {
        return clientInfo;
    }
}
