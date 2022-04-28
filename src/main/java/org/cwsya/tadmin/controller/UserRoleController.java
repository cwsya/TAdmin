package org.cwsya.tadmin.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.exception.ParameterException;
import org.cwsya.tadmin.pojo.PO.RoleAccessEntity;
import org.cwsya.tadmin.pojo.PO.UserRoleEntity;
import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.cwsya.tadmin.service.UserRoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户角色对应接口
 * @author cws
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @SaCheckRole("admin")
    @PostMapping("/addUserRole")
    public Result<?> addUserRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer uid = jsonObject.getInt("uid");
        Integer rid = jsonObject.getInt("rid");
        if (StrUtil.isBlankIfStr(uid)||StrUtil.isBlankIfStr(rid)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userRoleService.addUserRole(new UserRoleEntity(null,uid,rid,null)));
    }
    @SaCheckRole("admin")
    @PostMapping("/delUserRole")
    public Result<?> delUserRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),userRoleService.delUserRole(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/getUserRole")
    public Result<?> getUserRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)){
            throw new ParameterException();
        }
        Page<UserRoleEntity> role = userRoleService.getUserRole(current,size);
        Map<String,Object> map=new HashMap<>(size);
        map.put("userRole",role.getRecords());
        map.put("page",role.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }

}
