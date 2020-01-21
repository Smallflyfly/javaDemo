package com.wochanye.demo.constant;

/**
 * @author fangpf
 * @date 2020/1/19 14:35
 */
public enum RbacResponseEnum {
    //返回用户信息枚举
    USER_NOT_EXIST(400, "用户不存在"),
    USER_PASSWORD_ERROR(400,"用户密码错误"),
    TOKEN_GET_SUCCESS(200, "token获取成功"),
    USERNAME_EXIST(400,"用户名已存在"),
    USER_LOCKED(400,"用户已锁定"),
    PASSWORD_NULL(400,"密码不能为空"),

    ;

    public Integer coed;
    public String message;

    RbacResponseEnum(Integer coed, String message) {
        this.coed = coed;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCoed() {
        return coed;
    }
}
