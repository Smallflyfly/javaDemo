package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.model.dto.DeptDTO;
import com.wochanye.demo.model.vo.DeptVO;
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
     * @param pageQuery 分页参数
     * @return Result<List<DeptPO>>
     */
    Result<Map<String, List<DeptVO>>> getDeptList(PageQuery pageQuery);

    /**
     * 新增部门
     * @param deptDto 部门信息
     * @return Result
     */
    Result insetDept(DeptDTO deptDto);

    /**
     * 根据部门编号获取部门信息
     * @param deptNo 部门编号
     * @return Result<DeptVO>
     */
    Result<DeptVO> getDeptInfo(Integer deptNo);

    /**
     * 条件统计部门数量
     * @param deptDto 部门信息
     * @param pageQuery 分页信息
     * @return Integer
     */
    Result<Map<String, List<DeptVO>>> getSelectivePageList(DeptDTO deptDto, PageQuery pageQuery);
}
