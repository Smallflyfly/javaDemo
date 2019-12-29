package com.wochanye.demo.constant.meta;

/**
 * 对成功响应的代码和信息
 *
 * @author cuijie
 * @since 2018-07-03
 */
public enum ResponseEnum {

    //操作成功
    GET_INFO_SUCCESS(200, "获取成功"),
    OPERATION_SUCCESS(200, "操作成功"),
    //操作失败
    GET_INFO_FAIL(400, "获取失败"),
    OPERATION_FAIL(400, "操作失败");

    public int code;
    public String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
