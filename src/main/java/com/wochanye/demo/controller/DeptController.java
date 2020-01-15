package com.wochanye.demo.controller;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.model.vo.DeptVO;
import com.wochanye.demo.page.PageQuery;
import com.wochanye.demo.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author fangpf
 * @date 2020/1/10 11:03
 */

@RestController
@Api(tags = "部门相关接口")
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @PostMapping("/insertDept")
    @ApiOperation(value = "新部门插入", notes = "新部门插入")
    Result insertDept(@Validated DeptPO deptPo){
        return deptService.insetDept(deptPo);
    }

    @GetMapping("/deptList")
    @ApiOperation(value = "获取部门列表", notes = "获取部门列表")
    Result<Map<String, List<DeptVO>>> deptLit(@Validated PageQuery pageQuery){
        return deptService.getDeptList(pageQuery);
    }
    @GetMapping("/dept")
    @ApiOperation(value = "根据部门编号获取部门信息", notes = "根据部门编号获取部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptNo", value = "部门编号", required = true, example = "1"),
    })
    Result<DeptVO> deptInfo(@RequestParam("deptNo") Integer deptNo){
        return deptService.getDeptInfo(deptNo);
    }
}
