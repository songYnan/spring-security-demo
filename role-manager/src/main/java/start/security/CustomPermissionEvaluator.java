package start.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import start.entity.SysPermissionTest;
import start.service.SysPermissionService;
import start.service.SysRoleService;

/**
 * @author qiaolei
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
	
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysRoleService sysRoleService;

    /**
     *
     */
    @Override
	public boolean hasPermission(Authentication authentication, Serializable targetUrl, String arg2, Object targetPermission) {
    	
         return false;
	}
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()方法的结果
        User user = (User) authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        // 遍历用户所有角色
        for (GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Integer roleId = sysRoleService.selectByName(roleName);
            // 得到角色所有的权限
            List<SysPermissionTest> permissionList =sysPermissionService.listByRoleId(roleId);

            // 遍历权限
            for (SysPermissionTest sysPermission : permissionList) {
                // 获取权限集
               // List permissions = sysPermission.getPermissions();
            	String permissions=sysPermission.getPermission();
                // 如果访问的Url和权限用户符合的话，返回true
                if (targetUrl.equals(sysPermission.getUrl())
                        && permissions.contains(targetPermission.toString())) {
                    return true;
                }
            }

        }

        return false;
    }
/*
    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }*/
   
	
}
