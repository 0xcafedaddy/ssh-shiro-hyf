package com.whitehorse.qingzhi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.AuthorizationDao;
import com.whitehorse.qingzhi.entity.ManagerAuth;

import java.util.List;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
@Repository
public class AuthorizationDaoImpl implements AuthorizationDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Integer createAuthorization(ManagerAuth authorization) {
		int authorizationId = (int) hibernateTemplate.save(authorization);
		return authorizationId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerAuth> findAuthByName(String authName) {
		String hql = "from ManagerAuth m where m.mauthName = :authName and m.mauthIsDelete = false";
		List<ManagerAuth> mAuthList = (List<ManagerAuth>) hibernateTemplate.findByNamedParam(hql, "authName", authName);
		return mAuthList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerAuth> findAll() {
		String hql = "from ManagerAuth m where m.mauthIsDelete = false";
		List<ManagerAuth> mAuthList = (List<ManagerAuth>) hibernateTemplate.find(hql);
		
		return mAuthList;
	}

	
}
