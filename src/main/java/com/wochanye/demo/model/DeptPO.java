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
public class DeptPO implements Serializable {

    @ApiModelProperty(value = "部门编号", example = "1")
    private Integer deptNo;

    @ApiModelProperty(value = "部门名称", example = "应用研发部")
    private String deptName;

    @ApiModelProperty(value = "部门级别", example = "1")
    private Byte deptLevel;

    @ApiModelProperty(value = "部门位置", example = "17楼")
    private String deptLoc;

    @ApiModelProperty(value = "操作员")
    private String operator;

    @ApiModelProperty(hidden = true, value = "创建时间")
    private Date createTime;

    @ApiModelProperty(hidden = true, value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}

