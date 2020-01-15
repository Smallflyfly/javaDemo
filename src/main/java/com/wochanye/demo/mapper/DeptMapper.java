package com.wochanye.demo.mapper;

import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.page.PageQuery;

import java.util.List;

/**
 * @author fangpf
 * @data 2020/1/10 11:03
 */
public interface DeptMapper {

    /**
     * 根据编号删除部门
     * @param deptNo 部门编号
     * @return void
     */
    void deleteByPrimaryKey(Integer deptNo);

    /**
     * 插入部门信息
     * @param record 部门信息
     * @return void
     */
    void insert(DeptPO record);

    /**
     *  根据部门编号获取部门信息
     * @param deptNo 部门编号
     * @return DeptPO
     */
    DeptPO selectByPrimaryKey(Integer deptNo);

    /**
     * 根据新部门信息更新部门
     * @param record 部门信息
     * @return void
     */
    void updateByPrimaryKey(DeptPO record);

    /**
     * 获取部门列表
     * @param pageQuery
     * @return List
     */
    List<DeptPO> getDeptList(PageQuery pageQuery);

    /**
     * 统计数量
     * @param
     * @return Integer
     */
    Integer selectCount();
}