package com.whitehorse.qingzhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitehorse.qingzhi.dao.AuthorizationDao;
import com.whitehorse.qingzhi.datasource.DataSourceKey;
import com.whitehorse.qingzhi.entity.ManagerAuth;
import com.whitehorse.qingzhi.service.AuthorizationService;
import com.whitehorse.qingzhi.service.ShiroFilerChainManager;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
@Service
@DataSourceKey("dataSourceAdmin")
public class AuthorizationServiceImpl implements AuthorizationService {
	@Autowired
    private ShiroFilerChainManager shiroFilerChainManager;
	
	@Autowired
	private AuthorizationDao authorizationDao;
	
	/**
	 * 
	 */
	@PostConstruct
    public void initFilterChain() {
        shiroFilerChainManager.initFilterChains(findAll());
    }
	
	@Override
	public Integer createAuthorization(ManagerAuth authorization) {
		
		return authorizationDao.createAuthorization(authorization);
	}

	@Override
	public List<ManagerAuth> findAuthByName(String authName) {
		
		return authorizationDao.findAuthByName(authName);
	}
	
	

	@Override
	public List<ManagerAuth> findAll() {
		List<ManagerAuth> managerAuthList = authorizationDao.findAll();
		//权限排序，先拦截权限最小的
		Collections.sort(managerAuthList);
		return managerAuthList;
	}
}
