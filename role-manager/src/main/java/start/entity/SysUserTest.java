package start.entity;

import java.io.Serializable;
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
 * @author ql
 */
@Entity
@Table(name="sys_user_test")
public class SysUserTest implements Serializable {
	static final long serialVersionUID = 1L;

	private List<SysRoleTest> sysRoleTestList;

	private String name;

	private String password;

	private Integer id;

	
	// @JoinColumn(name = "id")

	 @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "sysUserTestList", fetch = FetchType.LAZY)
	public List<SysRoleTest> getSysRoleTestList() {
		return sysRoleTestList;
	}

	public void setSysRoleTestList(List<SysRoleTest> sysRoleTestList) {
		this.sysRoleTestList = sysRoleTestList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	@SequenceGenerator(name = "sys_user_test_id_seq", sequenceName = "sys_user_test_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_user_test_id_seq")
	@Column(name = "id", unique = true, nullable = false)
	// @JoinTable(name="sys_user_role_test",joinColumns=@JoinColumn(name="role_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
