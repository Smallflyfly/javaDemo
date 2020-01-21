package com.wochanye.demo.mapper;

import com.wochanye.demo.model.UserPO;

/**
 * @author fangpf
 * @date 2020/1/19 13:58
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return UserPO
     */
    UserPO getUserByUsername(String userName);
}
