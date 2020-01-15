package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.ResponseUtil;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.mapper.DeptMapper;
import com.wochanye.demo.model.DeptPO;
import com.wochanye.demo.model.vo.DeptVO;
import com.wochanye.demo.page.PageQuery;
import com.wochanye.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
            DeptVO deptVO = new DeptVO();
            BeanUtils.copyProperties(deptPo, deptVO);
            return ResponseUtil.operateSuccess(deptVO);
        } catch (Exception e){
            log.info("部门不存在");
        }
        return ResponseUtil.operateFail();
    }
}
