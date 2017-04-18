package com.whitehorse.qingzhi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whitehorse.qingzhi.dao.ManagerDao;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLecturer;
import com.whitehorse.qingzhi.entity.ManagerLog;

import java.util.List;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
@Repository
public class ManagerDaoImpl implements ManagerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public ManagerInfo findByManagerAccount(String userAccount) {
		String hql = "from ManagerInfo u where u.managerAccount = ? and u.managerIsDelete = false";
		List<ManagerInfo> managerInfoList = (List<ManagerInfo>) hibernateTemplate.find(hql, userAccount);
		if(managerInfoList.size()!=0){
			ManagerInfo managerInfo = managerInfoList.get(0);
			return managerInfo;
		}
		
		return null;
	}

	@Override
	public Integer createManagerInfo(ManagerInfo managerInfo) {
		int managerInfoId = (int) hibernateTemplate.save(managerInfo);
		return managerInfoId;
	}

	@Override
	public Integer deleteManager(String userAccount) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		String hql = "update ManagerInfo u set u.managerIsDelete = true,u.managerDeleteTime = ? where u.managerAccount=?";
		Integer i = hibernateTemplate.bulkUpdate(hql, new Object[]{currentTime,userAccount});
		return i;
	}

	@Override
	public Integer addAuth(String account,String auth) {
		String hql = "update ManagerInfo u set u.managerAuth = ? where u.managerAccount=? and u.managerIsDelete = false";
		
		Integer i = hibernateTemplate.bulkUpdate(hql, new Object[]{auth,account});
		
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ManagerInfo findByManagerId(Integer id) {
		String hql = "from ManagerInfo u where u.managerId = ? and u.managerIsDelete = false";
		List<ManagerInfo> managerInfoList = (List<ManagerInfo>) hibernateTemplate.find(hql, id);
		if(managerInfoList.size()!=0){
			ManagerInfo managerInfo = managerInfoList.get(0);
			return managerInfo;
		}
		
		return null;
	}

	@Override
	public List<ManagerInfo> findByGrade(Integer grade) {
		
		String hql = "from ManagerInfo u where u.managerGrade = ? and u.managerIsDelete = false";
		
		List<ManagerInfo> managerInfoList = (List<ManagerInfo>) hibernateTemplate.find(hql, grade);
		
		return managerInfoList;
	}

	@Override
	public List<ManagerInfo> findManagerByElseId(Integer managerId) {
		String hql = "select distinct m from ManagerInfo m,ManagerLecturer l where m.managerId = l.mlManagerId "
				+ "and l.mlManagerId != :mamagerId and m.managerIsDelete = false and l.mlIsDelete = false";
		List<ManagerInfo> managerInfoList  = (List<ManagerInfo>) hibernateTemplate.findByNamedParam(hql, "mamagerId", managerId);
		
		return managerInfoList;
	}

}
