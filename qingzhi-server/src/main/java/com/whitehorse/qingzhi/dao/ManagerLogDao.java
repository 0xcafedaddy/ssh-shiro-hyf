package com.whitehorse.qingzhi.dao;

import org.springframework.stereotype.Repository;

import com.whitehorse.qingzhi.entity.ManagerLog;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Repository
public interface ManagerLogDao {
	/**
	 * 创建管理员操作日志
	 * @param managerLog
	 * @return
	 */
	Integer createManagerLog(ManagerLog managerLog);
}
