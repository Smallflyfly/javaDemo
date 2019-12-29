package com.wochanye.demo.exception;

import com.wochanye.demo.exception.meta.ExceptionEnum;

/**
 * 系统异常统一抛出处理
 *
 * @author cuijie
 * @since 2018-07-03
 */
public class ServiceException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

    public ServiceException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
