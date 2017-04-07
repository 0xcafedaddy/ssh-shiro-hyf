package com.whitehorse.qingzhi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.UserDao;
import com.whitehorse.qingzhi.entity.User;

import java.util.List;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		
		return (User) hibernateTemplate.find("from User u where u.username = ?", username).get(0);
	}
}
