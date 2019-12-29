package com.wochanye.demo.mapper;

import com.wochanye.demo.model.WocyDept;

import java.util.List;
import java.util.Map;

/**
 * 部门表Mapper（继承生成的Mapper接口，实现自己的sql调用）
 *
 * @author cuijie
 * @since 2018-06-26
 */
public interface WocyDeptExtMapper extends WocyDeptMapper {

    /**
     * 根据条件筛选获取部门总数统计
     *
     * @param param
     * @return
     */
    int selectCount(Map<String, Object> param);

    /**
     * 根据条件筛选获取部门列表
     *
     * @param param
     * @return
     */
    List<WocyDept> selectDeptList(Map<String, Object> param);

}
