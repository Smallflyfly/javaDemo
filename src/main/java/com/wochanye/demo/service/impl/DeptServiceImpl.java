package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.ResponseUtil;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.mapper.DeptExtMapper;
import com.wochanye.demo.mapper.DeptMapper;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.model.dto.DeptDTO;
import com.wochanye.demo.model.vo.DeptVO;
import com.wochanye.demo.page.PageQuery;
import com.wochanye.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangpf
 * @data 2020/1/10 16:13
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private DeptExtMapper deptExtMapper;

    @Override
    public Result<Map<String, List<DeptVO>>> getDeptList(PageQuery pageQuery) {
        List<DeptPO> deptPoList;
        List<DeptVO> deptVOList = new ArrayList<>();
        int total = 0;
        try {
            total = deptMapper.selectCount();
            pageQuery.setOffset((pageQuery.getPage()-1)*pageQuery.getPageSize());
            deptPoList = deptMapper.getDeptList(pageQuery);
            for (DeptPO deptPo:deptPoList){
                DeptVO deptVo = new DeptVO();
                BeanUtils.copyProperties(deptPo, deptVo);
                deptVOList.add(deptVo);
            }
            BeanUtils.copyProperties(deptPoList, deptVOList);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseUtil.getInfoPageListSuccess(total, deptVOList);
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

    @Override
    public Result getDeptInfo(Integer deptNo) {
        try {
            DeptPO deptPo = deptMapper.selectByPrimaryKey(deptNo);
            DeptVO deptVo = new DeptVO();
            BeanUtils.copyProperties(deptPo, deptVo);
            return ResponseUtil.operateSuccess(deptVo);
        } catch (Exception e){
            log.info("部门不存在");
        }
        return ResponseUtil.operateFail();
    }

    @Override
    public Result getSelectivePageList(DeptDTO deptDto, PageQuery pageQuery) {
        try{
            Map<String, Object> params = new HashMap<>(1<<5);
            if (deptDto.getDeptNo() != null){
                params.put("deptNo", deptDto.getDeptNo());
            }
            if (deptDto.getDeptName() != null){
                params.put("deptName", deptDto.getDeptName());
            }
            if (deptDto.getDeptLevel() != null){
                params.put("deptLevel", deptDto.getDeptLevel());
            }
            if (deptDto.getDeptLoc() != null){
                params.put("deptLoc", deptDto.getDeptLoc());
            }
            int total = deptExtMapper.selectCountExt(params);
            pageQuery.setOffset((pageQuery.getPage()-1) * pageQuery.getPageSize());
            params.put("pageQuery", pageQuery);
            List<DeptPO> deptPoList = deptExtMapper.selectiveDeptPageList(params);
            List<DeptVO> deptVOList = new ArrayList<>();
            for(DeptPO deptPo:deptPoList){
                DeptVO deptVo = new DeptVO();
                BeanUtils.copyProperties(deptPo, deptVo);
                deptVOList.add(deptVo);
            }
            return ResponseUtil.getInfoPageListSuccess(total, deptVOList);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseUtil.operateFail();
    }


}
