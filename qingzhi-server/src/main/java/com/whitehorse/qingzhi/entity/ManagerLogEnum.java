package com.whitehorse.qingzhi.entity;
/**
* @author hyf
* @date 2017年4月12日
* @description 
*/
public enum ManagerLogEnum {
	
	CREATE_MANAGER(0,"管理员被创建"),
	UPDATE_MANAGER(1,"更新了管理员"),
	DELETE_MANAGER(2,"删除了管理员"),
	ADD_AUTH(3,"添加权限"),
	ADD_MANAGER_LECTURER(4,"添加讲师"),
	DELETE_USER(5,"删除了用户"),
	DELETE_MANAGER_LECTURER(7,"删除了管理员讲师"),
	DELETEALL_MANAGER_LECTURER(8,"删除了管理员的所有讲师"),
	DELETEALL_LECTURER(9,"删除了讲师"),
	
	
	
	
	
	
	
	
	
	
	
	
	UPDATE_LECTURE_MANAGER(6,"修改了讲师");
	private Integer type;
	private String content;
	private ManagerLogEnum(Integer type, String content) {
		this.type = type;
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
