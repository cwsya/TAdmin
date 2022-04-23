package org.cwsya.tadmin.service;

import org.cwsya.tadmin.exception.UserErrorException;
import org.cwsya.tadmin.pojo.PO.UserAllEntity;
import org.cwsya.tadmin.pojo.VO.UserEntity;

/**
 * @author cws
 */
public interface LoginService {
    /**
     * 登录
     * @param user 账号信息
     * @return 是否成功
     */
    UserAllEntity login(UserEntity user) throws UserErrorException;

    /**
     * 验证是否登录
     * @return 是否登录
     */
    boolean isLogin();
}
