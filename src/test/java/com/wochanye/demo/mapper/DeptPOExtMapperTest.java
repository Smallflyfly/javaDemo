package com.wochanye.demo.mapper;

import com.wochanye.demo.DemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class DeptPOExtMapperTest extends DemoApplicationTests {

    @Resource
    private DeptExtMapper deptExtMapper;

    @Test
    public void selectCount() {
        Map<String, Object> param = new HashMap<>(2);
        Assert.assertTrue(deptExtMapper.selectCount(param) > 0);
    }

    @Test
    public void selectDeptList() {
        Map<String, Object> param = new HashMap<>(2);
        Assert.assertTrue(deptExtMapper.selectDeptList(param).size() > 0);
    }
}