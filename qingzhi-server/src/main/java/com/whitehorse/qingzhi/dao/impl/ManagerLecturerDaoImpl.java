package com.whitehorse.qingzhi.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.ManagerLecturerDao;
import com.whitehorse.qingzhi.entity.ManagerLecturer;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Repository
public class ManagerLecturerDaoImpl implements ManagerLecturerDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Integer createLecturer(ManagerLecturer managerLecturer) {
		int managerLecturerId = (int) hibernateTemplate.save(managerLecturer);
		return managerLecturerId;
	}

	@Override
	public Integer findLecturerByManagerId(Integer managerId) {
		
		String hql = "select count(*) from ManagerLecturer m where m.mlManagerId = :managerId and m.mlIsDelete = false";
		
		Long count = (Long) hibernateTemplate.findByNamedParam(hql, "managerId", managerId).listIterator().next();
		
		return count.intValue();
	}

	@Override
	public List<Integer> findLecturerIdById(Integer managerId) {
		String hql = "select m.mlLecturerId from ManagerLecturer m where m.mlManagerId = :managerId and m.mlIsDelete = false";
		
		List<Integer> ids = (List<Integer>) hibernateTemplate.findByNamedParam(hql, "managerId", managerId);
		
		return ids;
	}

	@Override
	public Integer deleteManagerLecturer(Integer managerId) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		String hql = "update ManagerLecturer m set m.mlIsDelete = true,m.mlDeleteTime =? where m.mlManagerId = ?";
		int result = hibernateTemplate.bulkUpdate(hql, new Object[]{currentTime,managerId});
		return result;
	}

	@Override
	public Integer deleteManagerLecturerById(Integer managerLecturerId) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		String hql = "update ManagerLecturer m set m.mlIsDelete = true,m.mlDeleteTime =? where m.mlId = ?";
		int result = hibernateTemplate.bulkUpdate(hql, new Object[]{currentTime,managerLecturerId});
		return result;
	}

	@Override
	public Integer updateManagerLecturerById(Integer managerLecturerId,Integer managerId) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		String hql = "update ManagerLecturer m set m.mlManagerId = ? ,m.mlUpdateTime =? where m.mlId = ? and m.mlIsDelete =false";
		int result = hibernateTemplate.bulkUpdate(hql, new Object[]{managerId,currentTime,managerLecturerId});
		return result;
	}

	@Override
	public List<Integer> findAllLecturerIds() {
		String hql = "select distinct l.mlLecturerId from ManagerLecturer l";
		List<Integer> ids = (List<Integer>) hibernateTemplate.find(hql);
		return ids;
	}

}
