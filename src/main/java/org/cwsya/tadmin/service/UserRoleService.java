package org.cwsya.tadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cwsya.tadmin.pojo.PO.RoleAccessEntity;
import org.cwsya.tadmin.pojo.PO.UserRoleEntity;

/**
 * 用户角色对应
 * @author cws
 */
public interface UserRoleService {
    /**
     * 添加用户角色对应数据
     * @param userRoleEntity 对应数据
     * @return 是否成功
     */
    boolean addUserRole(UserRoleEntity userRoleEntity);

    /**
     * 删除对应关系
     * @param id 对应的id
     * @return 是否成功
     */
    boolean delUserRole(Integer id);

    /**
     * 查对应表
     * @param current 页数
     * @param size 数量
     * @return 信息
     */
    Page<UserRoleEntity> getUserRole(Integer current, Integer size);
}
