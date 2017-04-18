package com.whitehorse.qingzhi.service;


import java.util.List;

import com.whitehorse.qingzhi.entity.UserBaseInfo;

/**
* @author hyf
* @date 2017年4月12日
* @description 
*/
public interface UserService {
	/**
	 * 添加用户
	 * @param userBaseInfo
	 * @return
	 */
	Integer createUser(UserBaseInfo userBaseInfo);
	
	List<UserBaseInfo> findAllUser();
	
	/**
	 * 根据用户名查询不唯一
	 * @param username
	 * @return
	 */
	List<UserBaseInfo> findUserByUserName(String username);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	Integer deleteUserById(Integer id);
	
	/**
	 * 根据微信id删除用户
	 * @param wxId
	 * @return
	 */
	Integer deleteUserByWX(String wxId);
	
	/**
	 * 分页查询所有用户
	 * @param page
	 * @param size
	 * @return
	 */
	List<UserBaseInfo> findUserByPage(int page, int size);
	
	/**
	 * 根据微信id获取用户
	 * @return
	 */
	UserBaseInfo findByOpenId(String wxId);
	
} 

