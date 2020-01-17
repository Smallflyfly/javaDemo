package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.model.dto.EmpDTO;
import com.wochanye.demo.model.vo.EmpVO;
import com.wochanye.demo.page.PageQuery;

import java.util.List;
import java.util.Map;

/**
 * @author fangpf
 * @date 2020/1/15 15:12
 */
public interface EmpService {
    /**
     * 插入员工信息
     * @param empPo 员工信息
     * @return void
     */
    Result insertEmp(EmpPO empPo);

    /**
     * 分页查询所有员工信息
     * @param empDto 员工查询条件
     * @param pageQuery 分页信息
     * @return Result<Map<String, List<EmpVO>>>
     */
    Result<Map<String, List<EmpVO>>> getEmpPageList(EmpDTO empDto, PageQuery pageQuery);
}
