package start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import start.entity.SysUserTest;
import start.repository.SysUserRepository;

/**
 * @author qiaolei
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUserTest selectById(Integer id) {
        return sysUserRepository.findAllById(id);
    }

    public SysUserTest selectByName(String name) {
        return sysUserRepository.findByName(name);
    }
    
    public SysUserTest selectByNameAndPw(String name,String pw) {
        return sysUserRepository.findByNameAndPw(name, pw);
    }
}
