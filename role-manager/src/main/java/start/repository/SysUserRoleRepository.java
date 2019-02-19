package start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import start.entity.SysUserRoleTest;
import start.entity.SysUserTest;

/**
 * @author ql
 */
@Repository
public interface SysUserRoleRepository  extends JpaRepository<SysUserRoleTest, Integer> {
	 @Query("select s from SysUserRoleTest s join SysUserTest r on s.userId=r.id where r.id=?")
    List<SysUserRoleTest> findByUserId(@Param("userId") Integer userId);
	 
}
