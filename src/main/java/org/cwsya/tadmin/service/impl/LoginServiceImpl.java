package org.cwsya.tadmin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.cwsya.tadmin.exception.UserErrorException;
import org.cwsya.tadmin.mapper.UserAllMapper;
import org.cwsya.tadmin.pojo.PO.UserAllEntity;
import org.cwsya.tadmin.pojo.VO.UserEntity;
import org.cwsya.tadmin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cws
 * 登录相关
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserAllMapper userAllMapper;
    @Override
    public UserAllEntity login(UserEntity user) throws UserErrorException {
        UserAllEntity userAllEntity = userAllMapper.selectUserAll(user);
        if (userAllEntity==null) {
            throw new UserErrorException();
        }
        StpUtil.login(userAllEntity.getId());

        return userAllEntity;
    }

    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }
    private void setRole(UserAllEntity userAllEntity){


    }
    private void setAccess(UserAllEntity userAllEntity){

    }
}
