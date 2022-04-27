package org.cwsya.tadmin.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.cwsya.tadmin.exception.ParameterException;
import org.cwsya.tadmin.exception.UserErrorException;
import org.cwsya.tadmin.pojo.PO.UserAllEntity;
import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.cwsya.tadmin.pojo.PO.UserEntity;
import org.cwsya.tadmin.service.LoginService;
import org.cwsya.tadmin.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cws
 * 登录相关的接口
 */
@RestController
public class LoginController implements Serializable {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody JSONObject jsonObject) throws UserErrorException, JsonProcessingException, ParameterException {
        String userName = jsonObject.getStr("userName");
        String passWord = jsonObject.getStr("passWord");
        //判断账号或密码是否为空
        if (StrUtil.isBlankIfStr(userName) || StrUtil.isBlankIfStr(passWord)){
            throw new ParameterException();
        }
        loginService.login(new UserEntity(null,userName,passWord,null,null,null));
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        HashMap<String,String> result = new HashMap<>(1);
        result.put(tokenInfo.tokenName,tokenInfo.tokenValue);
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),result);
    }
    @PostMapping("/isLogin")
    public Result<?> isLogin(){
        ResultCodeEnum codeEnum=ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),loginService.isLogin());
    }
    @PostMapping("/outLogin")
    public Result<?> outLogin(@RequestHeader("${sa-token.token-name}") String token) throws ParameterException {
        if (StrUtil.isBlankIfStr(token)) {
            throw new ParameterException();
        }
        loginService.outLogin(token);
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),true);
    }

}
