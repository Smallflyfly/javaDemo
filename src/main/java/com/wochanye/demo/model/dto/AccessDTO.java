package com.wochanye.demo.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fangpf
 * @date 2020/1/19 11:04
 */
@Data
public class AccessDTO implements Serializable {

    @ApiModelProperty(value = "登录用户token")
    private String token;

    @ApiModelProperty(value = "登录用户token过期时间")
    private Long tokenExpire;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "登录用户头像")
    private String avatar;

}
