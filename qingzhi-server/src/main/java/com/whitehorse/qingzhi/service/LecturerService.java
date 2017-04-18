package com.whitehorse.qingzhi.service;

import java.util.List;

import com.whitehorse.qingzhi.entity.LecturerInfo;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
public interface LecturerService {
	
	/**
	 * 添加讲师
	 */
	Integer createLecturer(LecturerInfo lecturerInfo);
	
	/**
	 * 根据讲师ids查询讲师
	 * @param ids
	 * @return
	 */
	List<LecturerInfo> findLecturersByIds(List<Integer> ids);
	
	
	/**
	 * 根据讲师id删除一个讲师
	 * @param lectureId
	 * @return
	 */
	Integer deleteLecture(Integer lectureId);
	
	
	/**
	 * 根据讲师ids查询不在里面的讲师
	 * @param ids
	 * @return
	 */
	List<LecturerInfo> findLecturersByNoIds(List<Integer> ids);
	
	
}
