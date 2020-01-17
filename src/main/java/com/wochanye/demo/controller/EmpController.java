package com.wochanye.demo.controller;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.model.dto.EmpDTO;
import com.wochanye.demo.model.vo.EmpVO;
import com.wochanye.demo.page.PageQuery;
import com.wochanye.demo.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/insert")
    @ApiOperation(value = "插入员工信息", notes = "插入员工信息")
    Result insert(@Validated EmpPO empPo){
        return empService.insertEmp(empPo);
    }


    @GetMapping("/list")
    @ApiOperation(value = "分页获取所有员工列表", notes = "分页获取所有员工列表")
    Result<Map<String, List<EmpVO>>> list(@Validated EmpDTO empDto, @Validated PageQuery pageQuery){
        return empService.getEmpPageList(empDto, pageQuery);
    }
}
