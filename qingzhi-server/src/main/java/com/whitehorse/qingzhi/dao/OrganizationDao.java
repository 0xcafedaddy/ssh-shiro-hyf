package com.whitehorse.qingzhi.dao;


import java.util.List;

import com.whitehorse.qingzhi.entity.Organization;
/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
public interface OrganizationDao {

    public Organization createOrganization(Organization organization);
    public Organization updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();

    List<Organization> findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
