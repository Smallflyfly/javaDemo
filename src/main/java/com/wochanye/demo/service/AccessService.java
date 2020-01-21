package com.wochanye.demo.service;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.model.dto.AccessDTO;

/**
 * @author fangpf
 * @date 2020/1/19 11:15
 */
public interface AccessService {
    /**
     * 用户登录接口
     * @param userName 用户名
     * @param passWord 密码
     * @return Result<AccessDTO>
     */
    Result<AccessDTO> userLogin(String  userName, String passWord);
}
