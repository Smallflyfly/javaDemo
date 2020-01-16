package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.ResponseUtil;
import com.wochanye.demo.config.Result;
import com.wochanye.demo.mapper.EmpMapper;
import com.wochanye.demo.model.EmpPO;
import com.wochanye.demo.model.vo.EmpVO;
import com.wochanye.demo.page.PageQuery;
import com.wochanye.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public Result getEmpPageList(PageQuery pageQuery) {
        try {
            int total = empMapper.selectCount();
            pageQuery.setOffset((pageQuery.getPage() - 1) * pageQuery.getPageSize());
            List<EmpPO> empPOList = empMapper.selectEmpPageList(pageQuery);
            List<EmpVO> empVOList = new ArrayList<>();

            for (EmpPO empPo:empPOList){
                EmpVO empVo = new EmpVO();
                BeanUtils.copyProperties(empPo, empVo);
            }
            return ResponseUtil.getInfoPageListSuccess(total, empVOList);
        } catch (Exception e){
            log.info("获取员工列表失败");
        }
        return ResponseUtil.operateFail();
    }
}
