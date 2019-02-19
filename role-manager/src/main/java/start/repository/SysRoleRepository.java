package start.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import start.entity.SysPermissionTest;
import start.entity.SysRoleTest;

/**
 * @author ql
 */
@Repository
public interface SysRoleRepository  extends JpaRepository<SysRoleTest ,Integer>{
	SysRoleTest findAllById(Integer id);
	
	 @Query(value="select u from SysRoleTest u where u.name=?1")
	 SysRoleTest findByName(String name);
	 
	 @Query("select s from SysRoleTest s join SysUserTest r on r.id=s.userId where r.id = ?1")
		List<SysRoleTest> findByUserId(@Param("userId") Integer userId);
}
