package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;

import java.util.List;

/**
 * @author fangpf
 * @data 2020/1/10 16:13
 */
public interface BaseInfoService {
    Result<List<DeptPO>> getDeptList();
}
