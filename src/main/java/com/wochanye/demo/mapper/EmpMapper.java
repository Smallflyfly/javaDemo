package com.wochanye.demo.mapper;

import com.wochanye.demo.model.EmpPO;

/**
 * @author fangpf
 * @date 2020/1/10 11:03
 */
public interface EmpMapper {
    /**
     * 插入新员工
     * @param record 员工信息
     * @return void
     */
    void insert(EmpPO record);

    /**
     * 根据员工编号删除员工
     * @param empNo 员工编号
     * @return void
     */
    void delete(Integer empNo);

    /**
     * 更新员工信息
     * @param empPo 员工信息
     * @return void
     */
    void update(EmpPO empPo);

    /**
     * 根据员工编号查询员工信息
     * @param empNo 员工编号
     * @return EmpPO
     */
    EmpPO select(Integer empNo);

}