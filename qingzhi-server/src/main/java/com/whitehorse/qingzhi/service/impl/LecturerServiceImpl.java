package com.whitehorse.qingzhi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitehorse.qingzhi.dao.LecturerDao;
import com.whitehorse.qingzhi.datasource.DataSourceKey;
import com.whitehorse.qingzhi.entity.LecturerInfo;
import com.whitehorse.qingzhi.service.LecturerService;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Service
@DataSourceKey("dataSourceUser")
public class LecturerServiceImpl implements LecturerService{
	
	@Autowired
	private LecturerDao lecturerDao;
	
	
	@Override
	public Integer createLecturer(LecturerInfo lecturerInfo) {
		
		return lecturerDao.createLecturer(lecturerInfo);
	}

	@Override
	public List<LecturerInfo> findLecturersByIds(List<Integer> ids) {
		
		return lecturerDao.findLecturersByIds(ids);
	}

	@Override
	public Integer deleteLecture(Integer lectureId) {
		
		return lecturerDao.deleteLecture(lectureId);
	}

	@Override
	public List<LecturerInfo> findLecturersByNoIds(List<Integer> ids) {
		
		return lecturerDao.findLecturersByNoIds(ids);
	}



}
