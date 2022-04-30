package org.cwsya.tadmin.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.exception.ParameterException;
import org.cwsya.tadmin.pojo.PO.RoleAccessEntity;
import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.cwsya.tadmin.pojo.VO.AccessRoleEntity;
import org.cwsya.tadmin.service.RoleAccessService;
import org.cwsya.tadmin.util.BeanCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色权限对应接口
 * @author cws
 */
@RestController
@RequestMapping("/roleAccess")
public class RoleAccessController {

    private final RoleAccessService roleAccessService;

    public RoleAccessController(RoleAccessService roleAccessService) {
        this.roleAccessService = roleAccessService;

    }

    @SaCheckRole("admin")
    @PostMapping("/addRoleAccess")
    public Result<?> addRoleAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer rid = jsonObject.getInt("rid");
        Integer aid = jsonObject.getInt("aid");
        if (StrUtil.isBlankIfStr(rid)||StrUtil.isBlankIfStr(aid)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),roleAccessService.addRoleAccess(new RoleAccessEntity(null,rid,aid,null)));
    }
    @SaCheckRole("admin")
    @PostMapping("/delRoleAccess")
    public Result<?> delRoleAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id = jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),roleAccessService.delRoleAccess(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/getRoleAccess")
    public Result<?> getRoleAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        Integer roleid=jsonObject.getInt("roleid");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)||StrUtil.isBlankIfStr(roleid)){
            throw new ParameterException();
        }
        Page<RoleAccessEntity> role = roleAccessService.getRoleAccess(current,size,roleid);
        List<org.cwsya.tadmin.pojo.VO.RoleAccessEntity> list = BeanCopyUtils.copyBeanList(role.getRecords(), org.cwsya.tadmin.pojo.VO.RoleAccessEntity.class);
        Map<String,Object> map=new HashMap<>(size);
        map.put("access",list);
        map.put("page",role.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
    @SaCheckRole("admin")
    @PostMapping("/getAccessRole")
    public Result<?> getAccessRole(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        Integer accessid=jsonObject.getInt("accessid");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)||StrUtil.isBlankIfStr(accessid)){
            throw new ParameterException();
        }
        Page<RoleAccessEntity> role = roleAccessService.getAccessRole(current,size,accessid);
        List<AccessRoleEntity> list = BeanCopyUtils.copyBeanList(role.getRecords(), AccessRoleEntity.class);
        Map<String,Object> map=new HashMap<>(size);
        map.put("role",list);
        map.put("page",role.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
}
