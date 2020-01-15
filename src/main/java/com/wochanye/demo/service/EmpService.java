package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.EmpPO;

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
}
