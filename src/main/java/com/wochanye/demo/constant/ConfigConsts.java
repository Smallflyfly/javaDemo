package com.wochanye.demo.constant;

/**
 * 系统配置常量定义
 *
 * @author cuijie
 * @since 2018-06-27
 */
public class ConfigConsts {

    /**
     * 默认系统管理员
     */
    public static final String DEFAULT_SYSTEM_OPERATOR = "Admin";

    /**
     * SessionId
     */
    public static final String SESSION_ID = "sessionId";

    /**
     * Session对象Key, 用户id
     */
    public static final String SESSION_USER_ID = "userId";

    public interface Auth{
        String TOKEN_KEY = "token";
        String TOKEN_EXPIRE_KEY = "tokenExpire";
        String TOKEN_ID_KEY = "id";
        String TOKEN_USERNAME_KEY = "username";
        String TOKEN_EXPIRE_TIME = "time";
    }

    public interface Session{

    }

    /**
     * 客户端信息
     */
    public interface Client{
        String USER_AGENT = "User-Agent";
    }

}
