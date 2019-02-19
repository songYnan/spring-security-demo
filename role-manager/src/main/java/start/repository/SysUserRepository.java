package start.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import start.entity.SysUserTest;

/**
 * @author ql
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUserTest, Integer> {
    SysUserTest findAllById(Integer id);

    SysUserTest findByName(String name);
    @Query("select s from SysUserTest s  where s.name = ?1 and s.password = ?1")
    SysUserTest findByNameAndPw(@Param("name")String name,@Param("password")String pw);
}
