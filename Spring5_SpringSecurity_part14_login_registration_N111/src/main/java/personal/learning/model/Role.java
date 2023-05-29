package personal.learning.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Role {
	
	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
	@SequenceGenerator(name = "role_generator", sequenceName = "ROLE_SEQUENCE", allocationSize = 1)
	private int roleId;
	
	@Column(name="AUTHORITY")
	private String authority;
	
	public Role() {}
	
	public Role(int roleId, String authority) {
		this.roleId = roleId;
		this.authority = authority;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
