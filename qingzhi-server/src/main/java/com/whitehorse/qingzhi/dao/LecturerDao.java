package com.whitehorse.qingzhi.dao;

import java.util.List;

import com.whitehorse.qingzhi.entity.LecturerInfo;

/**
* @author hyf
* @date 2017年4月14日
* @description 
*/
public interface LecturerDao {
	
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
	 * 分页查询所有讲师
	 * @param page
	 * @param size
	 * @return
	 */
	List<LecturerInfo> findAll(int page,int size);
	
	
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
