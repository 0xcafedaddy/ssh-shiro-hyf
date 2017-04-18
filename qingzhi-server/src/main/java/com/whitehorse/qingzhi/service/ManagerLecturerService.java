package com.whitehorse.qingzhi.service;

import java.util.List;

import org.springframework.stereotype.Service;


/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Service
public interface ManagerLecturerService {

	/**
	 * 给讲师管理员添加讲师(最多10个)
	 * @param managerLecturer
	 * @return
	 */
	Integer addLecturer(Integer managerId, Integer lecturerId,String lecturerName,Integer ip);
	
	
	
	/**
	 * 根据管理员id 查询其管理的讲师
	 * @param ids
	 * @return
	 */
	List<Integer> findLecturersByIds(Integer id);
	
	/**
	 * 根据管理员id删除讲师
	 * @param managerLecturerId
	 * @return
	 */
	Integer deleteManagerLecturer(Integer managerId);
	
	
	/**
	 * 根据管理讲师id删除讲师
	 * @param managerLecturerId
	 * @return
	 */
	Integer deleteManagerLecturerById(Integer managerLecturerId);
	
	/**
	 * 修改讲师的管理员
	 * @param managerId
	 * @return
	 */
	Integer updateManagerLecturerById(Integer managerLecturerId,Integer managerId);
	
	/**
	 * 获取所有被管理的讲师id
	 * @return
	 */
	List<Integer> findAllLecturerIds();
}
