package com.wochanye.demo.model;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "员工编号", hidden = true)
    private Integer empNo;

    @ApiModelProperty(value = "员工姓名", example = "周杰伦")
    private String empName;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "入职时间")
    private Date employDate;

    @ApiModelProperty(value = "部门编号",example = "1")
    private Integer deptNo;

    @ApiModelProperty(value = "职务", example = "Java开发工程师")
    private String job;

    @ApiModelProperty(value = "操作员", example = "admin")
    private String operator;

    @ApiModelProperty(hidden = true, value = "创建时间")
    private Date createTime;

    @ApiModelProperty(hidden = true, value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}