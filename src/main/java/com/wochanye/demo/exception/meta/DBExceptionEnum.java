package com.wochanye.demo.exception.meta;

/**
 * 数据库异常枚举 20000开始
 *
 * @author cuijie
 * @since 2018-07-03
 */
public enum DBExceptionEnum implements ExceptionEnum {

    //数据库异常代码
    UNIQUE_KEY(20000, "主键不允许重复"),
    SQL_SYNTAX(20001, "数据库语法错误"),
    NOT_EXIST(20002, "数据不存在");

    public int code;
    public String message;

    DBExceptionEnum(int code, String message) {
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
