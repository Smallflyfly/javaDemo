package com.wochanye.demo.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author fangpf
 * @data 2020/1/13 11:22
 */
@Getter
@Setter
@ApiModel(description = "分页信息", value = "分页信息")
public class PageQuery implements Serializable {

    @ApiModelProperty(value = "当前页", example = "1", required = true)
    @NotNull(message = "当前页不能为空")
    @Min(value = 1, message = "当前页码不合法")
    private Integer page = 1;

    @ApiModelProperty(value = "展示数量", example = "10", required = true)
    @NotNull(message = "展示数量不能为空")
    @Min(value = 1, message = "展示数量不合法")
    private Integer pageSize = 10;

    @ApiModelProperty(hidden = true, value = "偏移量")
    private Integer offset;
}
