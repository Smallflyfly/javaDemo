package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.ResponseUtil;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.mapper.EmpMapper;
import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fangpf
 * @date 2020/1/15 15:13
 */
@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public Result insertEmp(EmpPO empPo) {
        try{
            empMapper.insert(empPo);
            return ResponseUtil.operateSuccess();
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseUtil.operateFail();
    }
}
