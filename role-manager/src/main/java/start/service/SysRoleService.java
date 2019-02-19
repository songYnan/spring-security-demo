package start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.entity.SysRoleTest;
import start.repository.SysRoleRepository;

/**
 * @author qiaolei
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleRepository sysRoleRepository;

    public SysRoleTest selectById(Integer id) {
        return sysRoleRepository.findAllById(id);
    }

    public Integer selectByName(String name) {
        return sysRoleRepository.findByName(name).getId();
    }
    public List<SysRoleTest> findByUserId(Integer userId){
    	 return sysRoleRepository.findByUserId(userId);
    }
}
