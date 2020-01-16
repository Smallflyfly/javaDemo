package com.wochanye.demo.mapper;

import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.page.PageQuery;

import java.util.List;

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

    /**
     * 根据身份证号查询员工信息
     * @param  idCard 身份证号
     * @return EmpPO
     */
    EmpPO selectByIdCard(String idCard);

    /**
     * 分页查询所有员工信息
     * @param pageQuery 分页信息
     * @return List<EmpPO>
     */
    List<EmpPO> selectEmpPageList(PageQuery pageQuery);

    /**
     * 统计总共有多少员工
     * @param
     * @return Integer
     */
    Integer selectCount();
}