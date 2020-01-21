package com.wochanye.demo.service;

import com.wochanye.demo.model.UserPO;

/**
 * @author fangpf
 * @date 2020/1/19 11:27
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return UserPO
     */
    UserPO getUserInfo(String userName);

    /**
     * 验证用户密码是否正确
     * @param password 用户输入的密码
     * @param userPo 查询到的用户信息
     * @return Boolean
     */
    Boolean checkPassword(String password, UserPO userPo);
}
