package com.wochanye.demo.model;

import java.io.Serializable;
import java.util.Date;

public class WocyDept implements Serializable {
    private Integer deptNo;

    private String deptName;

    private Byte deptLevel;

    private String deptLoc;

    private Integer deptPNo;

    private String operator;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Byte getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Byte deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptLoc() {
        return deptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc == null ? null : deptLoc.trim();
    }

    public Integer getDeptPNo() {
        return deptPNo;
    }

    public void setDeptPNo(Integer deptPNo) {
        this.deptPNo = deptPNo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}