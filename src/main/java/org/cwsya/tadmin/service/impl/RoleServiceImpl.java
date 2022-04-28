package org.cwsya.tadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.mapper.RoleMapper;
import org.cwsya.tadmin.pojo.PO.AccessEntity;
import org.cwsya.tadmin.pojo.PO.RoleEntity;
import org.cwsya.tadmin.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色相关操作
 * @author cws
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public boolean addRole(RoleEntity roleEntity) {
        roleMapper.insert(roleEntity);
        return true;
    }

    @Override
    public boolean stopRole(Integer id) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(id);
        roleEntity.setStatus(0);
        roleMapper.updateById(roleEntity);
        return true;
    }

    @Override
    public boolean startRole(Integer id) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(id);
        roleEntity.setStatus(1);
        roleMapper.updateById(roleEntity);
        return true;
    }

    @Override
    public Page<RoleEntity> getRole(Integer current, Integer size) {
        Page<RoleEntity> page=new Page<>(current,size);
        roleMapper.selectPage(page,null);
        return page;
    }
}
