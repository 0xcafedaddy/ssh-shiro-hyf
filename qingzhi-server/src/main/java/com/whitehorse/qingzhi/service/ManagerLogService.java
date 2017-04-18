package com.whitehorse.qingzhi.service;

import com.whitehorse.qingzhi.entity.ManagerLogEnum;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
public interface ManagerLogService {

	/**
	 * 创建管理员操作日志
	 * @param managerLog
	 * @return
	 */
	Integer createManagerLog(Integer id ,ManagerLogEnum managerLogEnum);
}
