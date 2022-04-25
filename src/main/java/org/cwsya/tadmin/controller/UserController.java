package org.cwsya.tadmin.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.exception.ParameterException;
import org.cwsya.tadmin.pojo.PO.UserEntity;
import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.cwsya.tadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cws
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @SaCheckRole("admin")
    @PostMapping("/addUser")
    public Result<?> addUser(@RequestBody UserEntity user) throws ParameterException {
        if (StrUtil.isBlankIfStr(user.getUserName())||StrUtil.isBlankIfStr(user.getPassWord())){
            throw new ParameterException();
        }
        user.setId(null);
        user.setStatus(null);
        user.setUpdatedTime(null);
        user.setCreatedTime(null);
        boolean b = userService.addUser(user);
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;

        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(), b);
    }

    @SaCheckRole("admin")
    @PostMapping("/upUser")
    public Result<?> upUser(@RequestBody UserEntity user) throws ParameterException {
        if (StrUtil.isBlankIfStr(user.getId())||StrUtil.isBlankIfStr(user.getPassWord())){
            throw new ParameterException();
        }
        user.setCreatedTime(null);
        user.setUserName(null);
        user.setUpdatedTime(null);
        user.setStatus(null);
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userService.upUser(user));
    }
    @SaCheckRole("admin")
    @PostMapping("/stopUser")
    public Result<?> stopUser(@RequestBody Integer id) throws ParameterException {
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userService.stopUser(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/startUser")
    public Result<?> startUser(@RequestBody Integer id) throws ParameterException {
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userService.stopUser(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/getUser")
    public Result<?> getUser(@RequestBody JSONObject jsonObject) throws ParameterException {
        int current = jsonObject.getInt("current");
        int size = jsonObject.getInt("size");
        String name = jsonObject.getStr("name");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)){
            throw new ParameterException();
        }
        if (StrUtil.isBlankIfStr(name)){
            name=null;
        }
        Page<UserEntity> user = userService.getUser(current, size, name);
        Map<String,Object> map=new HashMap<>(2);
        map.put("user",user.getRecords());
        map.put("page",user.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
}
