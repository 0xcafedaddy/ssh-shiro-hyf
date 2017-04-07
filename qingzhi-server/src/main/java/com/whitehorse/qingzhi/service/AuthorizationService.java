package com.whitehorse.qingzhi.service;


import java.util.List;
import java.util.Set;

import com.whitehorse.qingzhi.entity.Authorization;

/**
* @author hyf
* @date 2017年4月5日
* @description 权限的CRUD
*/
public interface AuthorizationService {


    public Authorization createAuthorization(Authorization authorization);
    public Authorization updateAuthorization(Authorization authorization);
    public void deleteAuthorization(Long authorizationId);

    public Authorization findOne(Long authorizationId);
    public List<Authorization> findAll();

    /**
     * 根据AppKey和用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String appKey, String username);

    /**
     * 根据AppKey和用户名查找权限字符串
     * @param username
     * @return
     */
    public Set<String> findPermissions(String appKey, String username);


}
