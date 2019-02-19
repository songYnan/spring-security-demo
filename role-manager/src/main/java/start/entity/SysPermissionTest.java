package start.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 权限实体类
 *
 * @author ql
 */
@Entity
@Table(name="sys_permission")
public class SysPermissionTest implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String url;

    private List<SysRoleTest> sysRoleTestList=new ArrayList<SysRoleTest>();

    private String permission;
    
    private Integer roleId;

	@Id 
    @SequenceGenerator(name = "sys_permission_id_seq", sequenceName = "sys_permission_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_permission_id_seq")
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   

    public String getPermission() {
        return permission;
    }
    
    @JoinTable(name="sys_role_permission" ,joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="role_id"))
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    public List<SysRoleTest> getSysRoleTestList() {
		return sysRoleTestList;
	}


	public void setPermission(String permission) {
        this.permission = permission;
    }
	@Column(name="role_id")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setSysRoleTestList(List<SysRoleTest> sysRoleTestList) {
		this.sysRoleTestList = sysRoleTestList;
	}
	

}
