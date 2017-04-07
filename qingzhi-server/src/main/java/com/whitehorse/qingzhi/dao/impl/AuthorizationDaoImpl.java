package com.whitehorse.qingzhi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.AuthorizationDao;
import com.whitehorse.qingzhi.entity.Authorization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
@Repository
public class AuthorizationDaoImpl implements AuthorizationDao {

	@Override
	public Authorization createAuthorization(Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authorization updateAuthorization(Authorization authorization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuthorization(Long authorizationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Authorization findOne(Long authorizationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authorization> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authorization findByAppUser(Long appId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
