package com.wochanye.demo.service.impl;

import com.wochanye.demo.mapper.UserMapper;
import com.wochanye.demo.model.UserPO;
import com.wochanye.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fangpf
 * @date 2020/1/19 14:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserPO getUserInfo(String userName) {
        return userMapper.getUserByUsername(userName);
    }

    @Override
    public Boolean checkPassword(String password, UserPO userPo) {
        //只做简单验证 后续补充md5校验等
        return password.equals(userPo.getPassword());
    }
}
