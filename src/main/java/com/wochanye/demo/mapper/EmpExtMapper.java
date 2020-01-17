package com.wochanye.demo.mapper;

import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.page.PageQuery;

import java.util.List;
import java.util.Map;

/**
 * @author fangpf
 * @data 2020/1/10 11:03
 */
public interface EmpExtMapper extends EmpMapper {

    /**
     * 根据参数获取员工总数
     * @param param 参数
     * @return int
     */
    int selectCountExt(Map<String, Object> param);

    /**
     * 有条件分页查询所有员工信息
     * @param param 查询参数
     * @return List<EmpPO>
     */
    List<EmpPO> selectEmpPageList(Map<String, Object> param);

}
