package com.wochanye.demo.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fangpf
 * @since 2020-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EnterprisePosition对象", description="")
public class EnterprisePosition extends Model<EnterprisePosition> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "职位序号")
    private String id;

    @ApiModelProperty(value = "公司Id")
    private String enterpriseId;

    @ApiModelProperty(value = "公司名称")
    private String enterpriseName;

    @ApiModelProperty(value = "职位名称")
    private String position;

    @ApiModelProperty(value = "经验要求")
    private String experience;

    @ApiModelProperty(value = "学历要求")
    private String education;

    @ApiModelProperty(value = "薪资范围下限")
    private Integer salaryLower;

    @ApiModelProperty(value = "薪资范围上限")
    private Integer salaryUpper;

    @ApiModelProperty(value = "职位关键词")
    private String positionKey;

    @ApiModelProperty(value = "岗位描述小标题")
    private String positionTitle;

    @ApiModelProperty(value = "岗位描述正文内容")
    private String positionContent;

    @ApiModelProperty(value = "工作地址")
    private String workAddress;

    @ApiModelProperty(value = "发布时间")
    private Date releaseTime;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "工作城市行政区域编码")
    private String regionId;

    @ApiModelProperty(value = "工作城市行政区域全名")
    private String regionFullName;

    @ApiModelProperty(value = "招聘人数")
    private Integer hireNumber;

    @ApiModelProperty(value = "联系方式")
    private String phone;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
