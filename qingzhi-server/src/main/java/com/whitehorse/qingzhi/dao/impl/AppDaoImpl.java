package com.whitehorse.qingzhi.dao.impl;

import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.AppDao;
import com.whitehorse.qingzhi.entity.App;

import java.util.List;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/

@Repository
public class AppDaoImpl implements AppDao {

	@Override
	public App createApp(App app) {
		
		return null;
	}

	@Override
	public App updateApp(App app) {
		
		return null;
	}

	@Override
	public void deleteApp(Long appId) {
		
		
	}

	@Override
	public App findOne(Long appId) {
		
		return null;
	}

	@Override
	public List<App> findAll() {
		
		return null;
	}

	@Override
	public Long findAppIdByAppKey(String appKey) {
		
		return null;
	}


}
