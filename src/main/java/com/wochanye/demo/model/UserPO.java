package com.wochanye.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @author fangpf
 * @date 2020/1/19 11:27
 */
@Data
public class UserPO {
    private Integer userId;
    private String username;
    private String password;
    private Integer empNo;
    private String name;
    private String email;
    private String phone;
    private Integer deptNo;
    private String avatar;
    private String operator;
    private Date createTime;
    private Date updateTime;
    private Boolean locked;

    private static final long serialVersionUID = 1L;
}
