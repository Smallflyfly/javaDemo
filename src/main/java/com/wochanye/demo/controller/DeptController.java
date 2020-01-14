package com.wochanye.demo.controller;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.service.BaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangpf
 * @data 2020/1/10 11:03
 */

@RestController
@Api(tags = "测试用相关接口")
public class DeptController {

    @Resource
    private BaseInfoService baseInfoService;

    @GetMapping("/deptList")
    @ApiOperation(value = "Dept测试", notes = "Dept测试")
    Result<List<DeptPO>> getDeptLit(){
        return baseInfoService.getDeptList();
    }

    @PostMapping("/insertDept")
    @ApiOperation(value = "部门插入", notes = "部门插入")
    Result insertDept(@Validated DeptPO deptPo){
        return baseInfoService.insetDept(deptPo);
    }
}
