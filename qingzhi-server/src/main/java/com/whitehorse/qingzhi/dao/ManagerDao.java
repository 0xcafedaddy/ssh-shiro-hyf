package com.whitehorse.qingzhi.dao;


import java.util.List;

import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLecturer;
import com.whitehorse.qingzhi.entity.ManagerLog;

/**
 * @author hyf
 * @date 2017年4月5日
 * @description
 */
public interface ManagerDao {


	/**
	 * 添加管理员
	 * @param managerInfo
	 * @return
	 */
	Integer createManagerInfo(ManagerInfo managerInfo);

	/**
	 * 根据账号获得管理员
	 * @param userAccount
	 * @return
	 */
	ManagerInfo findByManagerAccount(String userAccount);
	
	/**
	 * 根据账号删除管理员
	 * @param userAccount
	 * @return
	 */
	Integer deleteManager(String userAccount); 


	/**
	 * 添加更新管理员权限
	 * @param account
	 * @param auth
	 * @return
	 */
	Integer addAuth(String account,String auth);
	

	/**
	 * 根据id查找管理员
	 * @param id
	 * @return
	 */
	ManagerInfo findByManagerId(Integer id);
	
	/**
	 * 根据等级查找管理员
	 * @param grade
	 * @return
	 */
	List<ManagerInfo> findByGrade(Integer grade);
	
	/**
     * 根据管理员ID，获取其他讲师的管理员(配合修改讲师管理员使用)
     * @param mamagerId
     * @return
     */
    List<ManagerInfo> findManagerByElseId(Integer managerId);
}
