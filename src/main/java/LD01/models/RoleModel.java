package LD01.models;

import java.io.Serializable;

public class RoleModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int roleid;
	private String rolename;

	public RoleModel() {
		super();
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "RoleModel [roleid=" + roleid + ", rolename=" + rolename + "]";
	}

}
