package start.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author ql
 */
@Entity
@Table(name="sys_role_test")
public class SysRoleTest implements Serializable {
    static final long serialVersionUID = 1L;
    
    private List<SysUserTest> sysUserTestList;

    private String name;
    private Integer Id;
   
    private Integer userId;
    
    private List<SysPermissionTest> sysPersissionList;
    
    
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "sysRoleTestList", fetch = FetchType.LAZY)
    public List<SysPermissionTest> getSysPersissionList() {
		return sysPersissionList;
	}



	public void setSysPersissionList(List<SysPermissionTest> sysPersissionList) {
		this.sysPersissionList = sysPersissionList;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@JoinTable(name="sys_user_role_test" ,joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="user_id"))
	@ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
	public List<SysUserTest> getSysUserTestList() {
		return sysUserTestList;
	}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   // 
	
 
	public void setSysUserTestList(List<SysUserTest> sysUserTestList) {
		this.sysUserTestList = sysUserTestList;
	}


	@Id
	@Column(name="id")
	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}
    
}
