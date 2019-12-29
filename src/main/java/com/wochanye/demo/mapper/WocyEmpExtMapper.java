package com.wochanye.demo.mapper;

import com.wochanye.demo.model.WocyEmp;

import java.util.List;
import java.util.Map;

/**
 * 员工表Mapper
 *
 * @author cuijie
 * @since 2016-06-26
 */
public interface WocyEmpExtMapper extends WocyEmpMapper {

    /**
     * 根据条件筛选获取员工总数统计
     *
     * @param param
     * @return
     */
    int selectCount(Map<String, Object> param);

    /**
     * 根据条件筛选获取员工列表
     *
     * @param param
     * @return
     */
    List<WocyEmp> selectEmpList(Map<String, Object> param);

}
