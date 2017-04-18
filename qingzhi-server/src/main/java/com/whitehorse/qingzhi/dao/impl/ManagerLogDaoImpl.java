package com.whitehorse.qingzhi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.ManagerLogDao;
import com.whitehorse.qingzhi.entity.ManagerLog;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Repository
public class ManagerLogDaoImpl implements ManagerLogDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Integer createManagerLog(ManagerLog managerLog) {
		int managerLogId = (int) hibernateTemplate.save(managerLog);
		return managerLogId;
	}

}
