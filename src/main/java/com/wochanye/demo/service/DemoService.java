package com.wochanye.demo.service;

import com.wochanye.demo.config.PageResult;
import com.wochanye.demo.model.WocyDept;
import com.wochanye.demo.model.WocyEmp;

import java.util.List;

/**
 * Demo演示
 *
 * @author cuijie
 * @since 2018-06-26
 */
public interface DemoService {

    PageResult<List<WocyDept>> getDeptInfoList(int page, int pageSize, String deptName);

    void addEditDept(int deptNo, String deptName, String deptLoc);

    PageResult<List<WocyEmp>> getEmpInfoList(Integer deptNo, Integer empNo, String empName);

    String getUrl(String key);

}
