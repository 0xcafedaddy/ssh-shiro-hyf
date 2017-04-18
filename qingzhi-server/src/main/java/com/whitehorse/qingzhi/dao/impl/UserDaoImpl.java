package com.whitehorse.qingzhi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.UserDao;
import com.whitehorse.qingzhi.entity.UserBaseInfo;

/**
* @author hyf
* @date 2017年4月12日
* @description 
*/
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer createUser(UserBaseInfo userBaseInfo) {
		int userId = (int) hibernateTemplate.save(userBaseInfo);
		return userId;
	}

	@Override
	public List<UserBaseInfo> findAllUser() {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBaseInfo> findUserByUserName(String username) {
		
		String hql = " from UserBaseInfo u where u.userNickname = :username and u.userIsDelete = false";
		
		List<UserBaseInfo>  userlist = (List<UserBaseInfo>) hibernateTemplate.findByNamedParam(hql, "username", username);
		
		return userlist;
	}

	@Override
	public Integer deleteUserById(Integer id) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		String hql = "update UserBaseInfo u set u.userIsDelete = true,u.userDeleteTime = ? where u.userId = ?";
		int i = hibernateTemplate.bulkUpdate(hql, new Object[]{currentTime,id});
		return i;
	}

	@Override
	public Integer deleteUserByWX(String wxId) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		String hql = "update UserBaseInfo u set u.userIsDelete = true,u.userDeleteTime = ? where u.userWxOpenid = ?";
		int i = hibernateTemplate.bulkUpdate(hql, new Object[]{currentTime,wxId});
		return i;
	}

	@Override
	public List<UserBaseInfo> findUserByPage(int page, int size) {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserBaseInfo u where u.userIsDelete = false")
		.setFirstResult((page-1)*size)
		.setMaxResults(size);
		return query.list();
	}

	@Override
	public UserBaseInfo findByOpenId(String wxId) {
		
		String hql = " from UserBaseInfo u where u.userWxOpenid = :wxId and u.userIsDelete = false";
		
		List<UserBaseInfo>  userlist = (List<UserBaseInfo>) hibernateTemplate.findByNamedParam(hql, "wxId", wxId);
		
		if(userlist.size()>0){
			UserBaseInfo userBaseInfo = userlist.get(0);
			return userBaseInfo;
		}
		
		return null;
	}
	
}
