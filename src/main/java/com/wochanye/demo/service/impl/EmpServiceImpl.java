package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.ResponseUtil;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.mapper.EmpExtMapper;
import com.wochanye.demo.mapper.EmpMapper;
import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.model.dto.EmpDTO;
import com.wochanye.demo.model.vo.EmpVO;
import com.wochanye.demo.page.PageQuery;
import com.wochanye.demo.service.EmpService;
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
 * @date 2020/1/15 15:13
 */
@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Resource
    private EmpExtMapper empExtMapper;

    @Override
    public Result insertEmp(EmpPO empPo) {
        try{
            EmpPO ep = empMapper.selectByIdCard(empPo.getIdCard());
            if (null != ep){
                log.info("此人已存在，插入失败");
                return ResponseUtil.operateFail(400, "此身份证号已存在，插入失败");
            }
            empMapper.insert(empPo);
            return ResponseUtil.operateSuccess();
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseUtil.operateFail(400, "插入失败");
    }

    @Override
    public Result getEmpPageList(EmpDTO empDto, PageQuery pageQuery) {
        try {
            Map<String, Object> params = new HashMap<>(1<<5);
            if (null != empDto.getEmpNo()){
                params.put("empNo", empDto.getEmpNo());
            }
            if (null != empDto.getEmpName()){
                params.put("empName", empDto.getEmpName());
            }
            if (null != empDto.getDeptNo()){
                params.put("deptNo", empDto.getDeptNo());
            }
            if (null != empDto.getGender()) {
                params.put("gender", empDto.getGender());
            }
            if (null != empDto.getIdCard()) {
                params.put("idCard", empDto.getIdCard());
            }
            if (null != empDto.getJob()) {
                params.put("job", empDto.getJob());
            }
            int total = empExtMapper.selectCountExt(params);
            pageQuery.setOffset((pageQuery.getPage() - 1) * pageQuery.getPageSize());
            params.put("pageQuery", pageQuery);
            List<EmpPO> empPoList = empExtMapper.selectEmpPageList(params);
            List<EmpVO> empVOList = new ArrayList<>();
            for (EmpPO empPo:empPoList){
                EmpVO empVo = new EmpVO();
                BeanUtils.copyProperties(empPo, empVo);
                empVOList.add(empVo);
            }
            return ResponseUtil.getInfoPageListSuccess(total, empVOList);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseUtil.operateFail();
    }
}
