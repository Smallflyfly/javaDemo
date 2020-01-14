package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;

import java.util.List;

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
    Result<List<DeptPO>> getDeptList();

    /**
     * 新增部门
     * @param deptPo
     * @return Result
     */
    Result insetDept(DeptPO deptPo);
}
