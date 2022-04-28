package org.cwsya.tadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.mapper.RoleAccessMapper;
import org.cwsya.tadmin.pojo.PO.AccessEntity;
import org.cwsya.tadmin.pojo.PO.RoleAccessEntity;
import org.cwsya.tadmin.service.RoleAccessService;
import org.springframework.stereotype.Service;

/**
 * 角色权限对应信息
 * @author cws
 */
@Service
public class RoleAccessServiceImpl implements RoleAccessService {

    private final RoleAccessMapper roleAccessMapper;

    public RoleAccessServiceImpl(RoleAccessMapper roleAccessMapper) {
        this.roleAccessMapper = roleAccessMapper;
    }

    @Override
    public boolean addRoleAccess(RoleAccessEntity roleAccessEntity) {
        roleAccessMapper.insert(roleAccessEntity);
        return true;
    }

    @Override
    public boolean delRoleAccess(Integer id) {
        roleAccessMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<RoleAccessEntity> getRoleAccess(Integer current, Integer size) {
        Page<RoleAccessEntity> page=new Page<>(current,size);
        roleAccessMapper.selectPage(page,null);
        return page;
    }
}
