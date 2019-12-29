package com.wochanye.demo.config;

import java.io.Serializable;

/**
 * @author fangpf
 * @data 2019/12/27 15:04
 */
public class PageResult<T> extends Result<T> implements Serializable {

    private int total;

    public PageResult(boolean success) {
        super(success);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
