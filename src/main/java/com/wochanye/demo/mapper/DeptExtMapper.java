package com.wochanye.demo.mapper;

import com.wochanye.demo.model.DeptPO;

import java.util.List;
import java.util.Map;

/**
 * 部门表Mapper（继承生成的Mapper接口，实现自己的sql调用）
 * @author fangpf
 * @date 2020.1.17
 */
public interface DeptExtMapper extends DeptMapper {

    /**
     * 根据条件筛选获取部门总数统计
     * @param param 筛选条件
     * @return int
     */
    int selectCountExt(Map<String, Object> param);

    /**
     * 根据条件筛选获取部门列表
     * @param param 查询参数
     * @return
     */
    List<DeptPO> selectiveDeptPageList(Map<String, Object> param);

}
