package com.wochanye.demo.mapper;

import com.wochanye.demo.model.EmpPO;

public interface EmpMapper {

    /**
     * 根据员工编号删除员工
     */
    /**
     * 根据条件筛选获取部门总数统计
     *
     * @param empNo
     * @return
     */
    int deleteByPrimaryKey(Integer empNo);

    /**
     * 插入新员工
     */
    int insert(EmpPO record);

    /**
     * 选择性插入
     */
    int insertSelective(EmpPO record);

    /**
     * 根据员工编号
     */
    EmpPO selectByPrimaryKey(Integer empNo);

    /**
     * 选择性更新员工信息
     */
    int updateByPrimaryKeySelective(EmpPO record);

    /**
     * 根据编号更新员工信息
     */
    int updateByPrimaryKey(EmpPO record);
}