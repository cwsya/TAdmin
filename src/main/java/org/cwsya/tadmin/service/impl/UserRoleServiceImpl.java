package org.cwsya.tadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.mapper.UserRoleMapper;
import org.cwsya.tadmin.pojo.PO.RoleAccessEntity;
import org.cwsya.tadmin.pojo.PO.UserRoleEntity;
import org.cwsya.tadmin.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色对应信息
 * @author cws
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleMapper userRoleMapper;

    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }


    @Override
    public boolean addUserRole(UserRoleEntity userRoleEntity) {
        userRoleMapper.insert(userRoleEntity);
        return true;
    }

    @Override
    public boolean delUserRole(Integer id) {
        userRoleMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<UserRoleEntity> getUserRole(Integer current, Integer size) {
        Page<UserRoleEntity> page=new Page<>(current,size);
        userRoleMapper.selectPage(page,null);
        return page;
    }
}
