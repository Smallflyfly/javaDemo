package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.ResponseUtil;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.mapper.DeptMapper;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.service.BaseInfoService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangpf
 * @data 2020/1/10 16:13
 */
@Service
@Slf4j
public class BaseInfoServiceImpl implements BaseInfoService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public Result<List<DeptPO>> getDeptList() {
        return null;
    }

    @Override
    public Result insetDept(DeptPO deptPo) {
        try{
            deptMapper.insert(deptPo);
        } catch (Exception e){
            log.info("插入部门出错");
        }
        return ResponseUtil.operateSuccess();
    }
}
