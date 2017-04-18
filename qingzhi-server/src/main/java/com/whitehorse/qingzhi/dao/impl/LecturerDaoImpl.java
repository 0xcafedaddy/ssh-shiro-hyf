package com.whitehorse.qingzhi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.dao.LecturerDao;
import com.whitehorse.qingzhi.entity.LecturerInfo;
import com.whitehorse.qingzhi.utils.TimeUtil;

/**
* @author hyf
* @date 2017年4月14日
* @description 
*/

@Repository
public class LecturerDaoImpl implements LecturerDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer createLecturer(LecturerInfo lecturerInfo) {
		Integer lecturerInfoId = (Integer) hibernateTemplate.save(lecturerInfo);
		return lecturerInfoId;
	}

	@Override
	public List<LecturerInfo> findAll(int page, int size) {
		//获取查询数据
        Query query=sessionFactory.getCurrentSession().createQuery("from LecturerInfo l where l.lecturerIsDelete = false"); 
        
        //获取分页数
        query.setFirstResult((page-1)*size).setMaxResults(size);
        
        return query.list(); 
	}


	@Override
	public List<LecturerInfo> findLecturersByIds(List<Integer> ids) {
		DetachedCriteria criteria =   DetachedCriteria.forClass(LecturerInfo.class);
		criteria.add(Restrictions.eq("lecturerIsDelete", false));
		criteria.add(Restrictions.in("lecturerId", ids));
		List<LecturerInfo> LecturerInfoList = (List<LecturerInfo>) hibernateTemplate.findByCriteria(criteria);
		return LecturerInfoList;
	}

	@Override
	public Integer deleteLecture(Integer lectureId) {
		
		String hql = "update LecturerInfo l set l.lecturerIsDelete = true , l.lecturerDeleteTime = ? where l.lecturerId = ?";
		
		return hibernateTemplate.bulkUpdate(hql, new Object[]{TimeUtil.getCurrentTime(),lectureId});
	}

	@Override
	public List<LecturerInfo> findLecturersByNoIds(List<Integer> ids) {
		DetachedCriteria criteria =   DetachedCriteria.forClass(LecturerInfo.class);
		criteria.add(Restrictions.eq("lecturerIsDelete", false));
		criteria.add(Restrictions.not(Restrictions.in("lecturerId", ids)));
		List<LecturerInfo> LecturerInfoList = (List<LecturerInfo>) hibernateTemplate.findByCriteria(criteria);
		return LecturerInfoList;
	}


	
	
	
}
