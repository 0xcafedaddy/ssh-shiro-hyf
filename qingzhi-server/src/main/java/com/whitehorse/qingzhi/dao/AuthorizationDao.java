package com.whitehorse.qingzhi.dao;


import java.util.List;

import com.whitehorse.qingzhi.entity.ManagerAuth;

/**
* @author hyf
* @date 2017年4月5日
* @description 权限CRUD
*/
public interface AuthorizationDao {

	/**
	 * 创建权限
	 * @param authorization
	 * @return
	 */
    Integer createAuthorization(ManagerAuth authorization);

    /**
     * 根据名字查找权限
     * @param authName
     * @return
     */
    List<ManagerAuth> findAuthByName(String authName);

    /**
     * 查找所有权限
     * @return
     */
	List<ManagerAuth> findAll();
    
}
