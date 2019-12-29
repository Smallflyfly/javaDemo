package com.wochanye.demo.mapper;

import com.wochanye.demo.model.WocyDept;

public interface WocyDeptMapper {
    int deleteByPrimaryKey(Integer deptNo);

    int insert(WocyDept record);

    int insertSelective(WocyDept record);

    WocyDept selectByPrimaryKey(Integer deptNo);

    int updateByPrimaryKeySelective(WocyDept record);

    int updateByPrimaryKey(WocyDept record);
}