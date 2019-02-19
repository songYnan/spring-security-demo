package start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import start.entity.SysPermissionTest;

/**
 * @author ql
 */
@Repository
public interface SysPermissionRepository extends JpaRepository<SysPermissionTest ,Integer> {
    /*@Select("SELECT * FROM sys_permission WHERE role_id=#{roleId}")
    List<SysPermission> listByRoleId(Integer roleId);*/
	 @Query("select s from SysPermission s join SysRoleTest r on s.roleId=r.id where r.id = ?1")
	List<SysPermissionTest> findByRoleId(@Param("roleId") Integer roleId);
}