package com.whitehorse.qingzhi.remote;

import java.io.Serializable;
import java.util.Set;

/**
* @author hyf
* @date 2017年4月5日
* @description 权限上下文
*/
public class PermissionContext implements Serializable{

	private static final long serialVersionUID = -6393140561884592182L;
	
	private Set<String> roles;
	private Set<String>	 permissions;
	
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
