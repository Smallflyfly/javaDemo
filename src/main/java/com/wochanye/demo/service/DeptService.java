package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.page.PageQuery;

import java.util.List;
import java.util.Map;

/**
 * @author fangpf
 * @data 2020/1/10 16:13
 */
public interface DeptService {
    /**
     * 获取部门列表
     * @param
     * @return Result<List<DeptPO>>
     */
    Result<Map<String, List<DeptPO>>> getDeptList(PageQuery pageQuery);

    /**
     * 新增部门
     * @param deptPo
     * @return Result
     */
    Result insetDept(DeptPO deptPo);
}
