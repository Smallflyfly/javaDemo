package com.wochanye.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangpf
 * @data 2020/1/10 11:03
 */

@Getter
@Setter
public class DeptPO implements Serializable {
    private Integer deptNo;

    private String deptName;

    private Byte deptLevel;

    private String deptLoc;

    private String operator;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}

