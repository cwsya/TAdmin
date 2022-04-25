package org.cwsya.tadmin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.cwsya.tadmin.exception.UserErrorException;
import org.cwsya.tadmin.pojo.PO.UserAllEntity;
import org.cwsya.tadmin.pojo.VO.UserEntity;

/**
 * @author cws
 */
public interface LoginService {

    /**
     * @param user 用户信息
     * @return 用户对象
     * @throws UserErrorException 错误
     * @throws JsonProcessingException 错误
     */
    UserAllEntity login(UserEntity user) throws UserErrorException, JsonProcessingException;

    /**
     * 验证是否登录
     * @return 是否登录
     */
    boolean isLogin();
}
