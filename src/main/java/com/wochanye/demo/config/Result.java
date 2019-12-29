package com.wochanye.demo.config;

import java.io.Serializable;

/**
 * @author fangpf
 * @data 2019/12/27 15:06
 */
public class Result<T>  implements Serializable {

    private boolean success;

    private int code;

    private String message;

    private T data;

    public Result(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
