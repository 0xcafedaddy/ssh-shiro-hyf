package com.whitehorse.qingzhi.service;



import java.util.List;

import com.whitehorse.qingzhi.entity.ManagerAuth;

/**
* @author hyf
* @date 2017年4月5日
* @description 权限的CRUD
*/
public interface AuthorizationService {


	/**
	 * 添加权限
	 * @param authorization
	 * @return
	 */
    Integer createAuthorization(ManagerAuth authorization);
    

    /**
     * 根据权限名字获取权限
     * @param authName
     * @return
     */
    List<ManagerAuth> findAuthByName(String authName);
    
    /**
     * 获取所有权限
     * @return
     */
    List<ManagerAuth> findAll();
    
    
}
