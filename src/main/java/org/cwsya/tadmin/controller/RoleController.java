package org.cwsya.tadmin.controller;


import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.exception.ParameterException;
import org.cwsya.tadmin.pojo.PO.RoleEntity;
import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.cwsya.tadmin.service.RoleService;
import org.cwsya.tadmin.util.BeanCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色相关接口
 * @author cws
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @SaCheckRole("admin")
    @PostMapping("/addRole")
    public Result<?> addAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        String roleName =jsonObject.getStr("roleName");
        if (StrUtil.isBlankIfStr(roleName)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),roleService.addRole(new RoleEntity(null,roleName,null,null,null)));
    }
    @SaCheckRole("admin")
    @PostMapping("/stopRole")
    public Result<?> stopAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id=jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),roleService.stopRole(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/startRole")
    public Result<?> startAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id=jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),roleService.startRole(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/getRole")
    public Result<?> getAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)){
            throw new ParameterException();
        }
        Page<RoleEntity> role = roleService.getRole(current,size);
        List<org.cwsya.tadmin.pojo.VO.RoleEntity> list = BeanCopyUtils.copyBeanList(role.getRecords(), org.cwsya.tadmin.pojo.VO.RoleEntity.class);

        Map<String,Object> map=new HashMap<>(size);
        map.put("role",list);
        map.put("page",role.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
}
