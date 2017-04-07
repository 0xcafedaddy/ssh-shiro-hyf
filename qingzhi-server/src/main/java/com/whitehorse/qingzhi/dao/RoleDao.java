package com.whitehorse.qingzhi.dao;


import java.util.List;

import com.whitehorse.qingzhi.entity.Role;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
public interface RoleDao {

    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
}
