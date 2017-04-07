package com.whitehorse.qingzhi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.ResourceDao;
import com.whitehorse.qingzhi.entity.Resource;

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
public class ResourceDaoImpl implements ResourceDao {

	@Override
	public Resource createResource(Resource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource updateResource(Resource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteResource(Long resourceId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Resource findOne(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
