package org.cwsya.tadmin.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cws
 * 权限角色配置
 */
@Component
public class SaTokenConfig implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
