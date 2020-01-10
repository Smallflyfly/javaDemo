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
public class EmpPO implements Serializable {
    private Integer empNo;

    private String empName;

    private String gender;

    private Date birthday;

    private Date employDate;

    private Integer deptNo;

    private String operator;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}