package com.wochanye.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fangpf
 * @date 2020/1/17 14:54
 */
@Data
public class EmpDTO implements Serializable {

    @ApiModelProperty(value = "员工编号")
    private Integer empNo;

    @ApiModelProperty(value = "员工姓名", example = "周杰伦")
    private String empName;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "身份证号码", example = "330102199003077253")
    private String idCard;

    @ApiModelProperty(value = "部门编号",example = "1")
    private Integer deptNo;

    @ApiModelProperty(value = "职务", example = "Java开发工程师")
    private String job;

    private static final long serialVersionUID = 1L;
}
