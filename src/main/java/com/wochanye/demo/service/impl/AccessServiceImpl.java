package com.wochanye.demo.service.impl;

import com.wochanye.demo.config.Result;
import com.wochanye.demo.constant.ConfigConsts;
import com.wochanye.demo.constant.RbacResponseEnum;
import com.wochanye.demo.model.UserPO;
import com.wochanye.demo.model.dto.AccessDTO;
import com.wochanye.demo.service.AccessService;
import com.wochanye.demo.service.UserService;
import com.wochanye.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author fangpf
 * @date 2020/1/19 11:18
 */
@Service
public class AccessServiceImpl implements AccessService {

    @Resource
    private UserService userService;

    @Resource
    private JwtUtil jwtUtil;

    @Value("${client.backend.access-expire-time}")
    private Long expireTime;

    @Override
    public Result<AccessDTO> userLogin(String username, String password) {
        UserPO userPo = userService.getUserInfo(username);
        Result<AccessDTO> result = new Result<>(false);
        if (null == userPo){
            result.setCode(RbacResponseEnum.USER_NOT_EXIST.getCoed());
            result.setMessage(RbacResponseEnum.USER_NOT_EXIST.getMessage());
            return result;
        }
        if (!userService.checkPassword(password, userPo)){
            result.setCode(RbacResponseEnum.USER_PASSWORD_ERROR.getCoed());
            result.setMessage(RbacResponseEnum.USER_PASSWORD_ERROR.getMessage());
            return result;
        }
        if (userPo.getLocked()){
            result.setCode(RbacResponseEnum.USER_LOCKED.getCoed());
            result.setMessage(RbacResponseEnum.USER_LOCKED.getMessage());
            return result;
        }
        Map<String, Object> tokenInfo = jwtUtil.createToken(userPo.getUserId().toString(), username, expireTime);
        AccessDTO accessDto = new AccessDTO();
        accessDto.setToken((String) tokenInfo.get(ConfigConsts.Auth.TOKEN_KEY));
        accessDto.setUsername((String) tokenInfo.get(ConfigConsts.Auth.TOKEN_USERNAME_KEY));
        accessDto.setTokenExpire((Long) tokenInfo.get(ConfigConsts.Auth.TOKEN_EXPIRE_KEY));
        accessDto.setAvatar(userPo.getAvatar());
        result.setData(accessDto);
        result.setCode(RbacResponseEnum.TOKEN_GET_SUCCESS.getCoed());
        result.setMessage(RbacResponseEnum.TOKEN_GET_SUCCESS.getMessage());
        result.setSuccess(true);
        return result;
    }
}
