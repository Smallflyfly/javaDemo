package com.wochanye.demo.mapper;

import com.wochanye.demo.model.WocyEmp;

public interface WocyEmpMapper {
    int deleteByPrimaryKey(Integer empNo);

    int insert(WocyEmp record);

    int insertSelective(WocyEmp record);

    WocyEmp selectByPrimaryKey(Integer empNo);

    int updateByPrimaryKeySelective(WocyEmp record);

    int updateByPrimaryKey(WocyEmp record);
}