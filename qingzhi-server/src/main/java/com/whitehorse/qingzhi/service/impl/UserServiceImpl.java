package com.whitehorse.qingzhi.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitehorse.qingzhi.dao.ManagerDao;
import com.whitehorse.qingzhi.dao.UserDao;
import com.whitehorse.qingzhi.datasource.DataSourceKey;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLog;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.entity.UserBaseInfo;
import com.whitehorse.qingzhi.service.UserService;
import com.whitehorse.qingzhi.utils.TimeUtil;

/**
* @author hyf
* @date 2017年4月12日
* @description 
*/
@Service
@DataSourceKey("dataSourceUser")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Integer createUser(UserBaseInfo userBaseInfo) {
		
		return userDao.createUser(userBaseInfo);
	}

	@Override
	public List<UserBaseInfo> findAllUser() {
		
		return null;
	}

	@Override
	public List<UserBaseInfo> findUserByUserName(String username) {
		
		return userDao.findUserByUserName(username);
	}

	@Override
	public Integer deleteUserById(Integer id) {
		
		int result = userDao.deleteUserById(id);
		
		return result;
	}

	@Override
	public List<UserBaseInfo> findUserByPage(int page, int size) {
		
		return userDao.findUserByPage(page, size);
	}

	@Override
	public Integer deleteUserByWX(String wxId) {
		
		return userDao.deleteUserByWX(wxId);
	}

	@Override
	public UserBaseInfo findByOpenId(String wxId) {
		
		return userDao.findByOpenId(wxId);
	}

}
