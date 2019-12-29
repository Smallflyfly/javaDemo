package com.wochanye.demo.exception.meta;

/**
 * 系统常见异常枚举 未知错误-1，其余10000开始
 *
 * @author cuijie
 * @since 2018-07-03
 */
public enum SysExceptionEnum implements ExceptionEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    NEED_LOGIN(10000, "必须登陆"),
    LOGIN_TIMEOUT(10001, "登陆超时"),
    BAD_REQUEST(10002, "非法请求"),
    PARAM_ERROR(10003, "参数错误"),
    SEARCH_FAIL(10004, "查询失败"),
    OPERATION_FAIL(10005, "操作失败");

    public int code;
    public String message;

    SysExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
