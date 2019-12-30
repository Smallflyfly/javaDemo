package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.PageResult;
import com.wochanye.demo.constant.ConfigConsts;
import com.wochanye.demo.exception.ServiceException;
import com.wochanye.demo.exception.meta.SysExceptionEnum;
import com.wochanye.demo.mapper.WocyDeptExtMapper;
import com.wochanye.demo.mapper.WocyEmpExtMapper;
import com.wochanye.demo.model.WocyDept;
import com.wochanye.demo.model.WocyEmp;
import com.wochanye.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo演示
 *
 * @author cuijie
 * @since 2018-06-26
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Resource
    private WocyDeptExtMapper wocyDeptExtMapper;

    @Resource
    private WocyEmpExtMapper wocyEmpExtMapper;


    @Override
    public PageResult<List<WocyDept>> getDeptInfoList(int page, int pageSize, String deptName) {
        return null;
    }

    @Override
    @Transactional()
    public void addEditDept(int deptNo, String deptName, String deptLoc) {
        try {
            WocyDept wocyDept = new WocyDept();
            wocyDept.setDeptName(deptName);
            wocyDept.setDeptLoc(deptLoc);
            wocyDept.setDeptLevel((byte) 2);
            wocyDept.setDeptPNo(1);
            wocyDept.setOperator(ConfigConsts.DEFAULT_SYSTEM_OPERATOR);
            if (deptNo == 0) {
                wocyDept.setCreateTime(new Date());
                wocyDeptExtMapper.insertSelective(wocyDept);
            } else {
                wocyDept.setDeptNo(deptNo);
                wocyDeptExtMapper.updateByPrimaryKeySelective(wocyDept);
            }
        } catch (Exception e) {
            logger.error("[{}]: deptNo: {}, deptName: {}, deptLoc: {} _ {}", SysExceptionEnum.OPERATION_FAIL.getCode(), deptNo, deptName, deptLoc, e.getMessage(), e);
            throw new ServiceException(SysExceptionEnum.OPERATION_FAIL);
        }
    }

    @Override
    public PageResult<List<WocyEmp>> getEmpInfoList(Integer deptNo, Integer empNo, String empName) {
        return null;
    }

}
