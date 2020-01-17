package com.wochanye.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author fangpf
 * @date 2020/1/17 13:58
 */
@Getter
@Setter
@ToString
public class DeptDTO implements Serializable {
    @ApiModelProperty(value = "部门编号", example = "1")
    private Integer deptNo;

    @ApiModelProperty(value = "部门名称", example = "应用研发部")
    private String deptName;

    @ApiModelProperty(value = "部门级别", example = "1")
    private Integer deptLevel;

    @ApiModelProperty(value = "部门位置", example = "17楼")
    private String deptLoc;

    private static final long serialVersionUID = 1L;
}
