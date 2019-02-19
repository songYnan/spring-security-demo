package start.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import start.entity.SysRoleTest;
import start.entity.SysUserRoleTest;
import start.entity.SysUserTest;
import start.service.SysRoleService;
import start.service.SysUserRoleService;
import start.service.SysUserService;
/**
 * @author qiaolei
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
     }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUserTest user = sysUserService.selectByName(username);

        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

       
        // 添加角色
        List<SysRoleTest> roles=sysRoleService.findByUserId(user.getId());
        for (SysRoleTest role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new User(user.getName(), bCryptPasswordEncoder().encode(user.getPassword()), authorities);
    }
    
}