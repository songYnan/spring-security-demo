package start.service;

/**
 * @author qiaolei
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.entity.SysPermissionTest;
import start.repository.SysPermissionRepository;

@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    /**
     * 获取指定角色所有权限
     */
    public List<SysPermissionTest> listByRoleId(Integer roleId) {
        return sysPermissionRepository.findByRoleId(roleId);
    }
}

