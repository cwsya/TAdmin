package org.cwsya.tadmin.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.hutool.core.util.StrUtil;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.exception.ParameterException;
import org.cwsya.tadmin.pojo.PO.AccessEntity;
import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.cwsya.tadmin.service.AccessService;
import org.cwsya.tadmin.util.BeanCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限相关接口
 * @author cws
 */
@RestController
@RequestMapping("/access")
public class AccessController {

    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @SaCheckRole("admin")
    @PostMapping("/addAccess")
    public Result<?> addAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        String accessName =jsonObject.getStr("accessName");
        if (StrUtil.isBlankIfStr(accessName)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),accessService.addAccess(new AccessEntity(null,accessName,null,null,null)));
    }
    @SaCheckRole("admin")
    @PostMapping("/stopAccess")
    public Result<?> stopAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id=jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),accessService.stopAccess(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/startAccess")
    public Result<?> startAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer id=jsonObject.getInt("id");
        if (StrUtil.isBlankIfStr(id)){
            throw new ParameterException();
        }
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),accessService.startAccess(id));
    }
    @SaCheckRole("admin")
    @PostMapping("/getAccess")
    public Result<?> getAccess(@RequestBody JSONObject jsonObject) throws ParameterException {
        Integer current=jsonObject.getInt("current");
        Integer size=jsonObject.getInt("size");
        if (StrUtil.isBlankIfStr(current)||StrUtil.isBlankIfStr(size)){
            throw new ParameterException();
        }
        Page<AccessEntity> access = accessService.getAccess(current,size);
        List<org.cwsya.tadmin.pojo.VO.AccessEntity> list = BeanCopyUtils.copyBeanList(access.getRecords(), org.cwsya.tadmin.pojo.VO.AccessEntity.class);

        Map<String,Object> map=new HashMap<>(2);
        map.put("access",list);
        map.put("page",access.getPages());
        ResultCodeEnum codeEnum = ResultCodeEnum.SUCCESS;
        return new Result<>(codeEnum.getResultCode(),codeEnum.getMessage(),map);
    }
}
