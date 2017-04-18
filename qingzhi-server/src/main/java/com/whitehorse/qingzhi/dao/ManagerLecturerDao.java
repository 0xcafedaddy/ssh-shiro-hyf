package com.whitehorse.qingzhi.dao;

import java.util.List;

import com.whitehorse.qingzhi.entity.ManagerLecturer;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
public interface ManagerLecturerDao {

	/**
	 * 创建管理员讲师
	 * @param managerLecturer
	 * @return
	 */
	Integer createLecturer(ManagerLecturer managerLecturer);
	
	/**
	 * 根据管理员id查询管理讲师数量
	 * @param managerId
	 * @return
	 */
	Integer findLecturerByManagerId(Integer managerId);
	
	/**
	 * 查询某管理员所管理的讲师ids
	 * @param managerId
	 * @return
	 */
	List<Integer> findLecturerIdById(Integer managerId);

	/**
	 * 根据管理员id删除
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
