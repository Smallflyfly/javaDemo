package com.wochanye.demo.controller;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fangpf
 * @date 2020/1/15 15:09
 */
@RestController
@RequestMapping("/emp")
@Api(tags = "员工相关接口")
public class EmpController {

    @Resource
    private EmpService empService;

    @PostMapping("/insertEmp")
    @ApiOperation(value = "插入员工信息", notes = "插入员工信息")
    Result insertEmp(@Validated EmpPO empPo){
        return empService.insertEmp(empPo);
    }
}
