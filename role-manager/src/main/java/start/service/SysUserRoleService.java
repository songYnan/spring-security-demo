package start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.entity.SysUserRoleTest;
import start.repository.SysUserRoleRepository;

/**
 * @author qiaolei
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    public List<SysUserRoleTest> listByUserId(Integer userId) {
        return sysUserRoleRepository.findByUserId(userId);
    }
}
