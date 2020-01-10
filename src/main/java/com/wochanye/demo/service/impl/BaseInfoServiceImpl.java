package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.service.BaseInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangpf
 * @data 2020/1/10 16:13
 */
@Service("baseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService {
    @Override
    public Result<List<DeptPO>> getDeptList() {
        return null;
    }
}
