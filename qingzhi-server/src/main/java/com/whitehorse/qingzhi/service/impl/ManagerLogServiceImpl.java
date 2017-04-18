package com.whitehorse.qingzhi.service.impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitehorse.qingzhi.dao.ManagerDao;
import com.whitehorse.qingzhi.dao.ManagerLogDao;
import com.whitehorse.qingzhi.datasource.DataSourceKey;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLog;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.service.ManagerLogService;
import com.whitehorse.qingzhi.utils.TimeUtil;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Service
@DataSourceKey("dataSourceAdmin")
public class ManagerLogServiceImpl implements ManagerLogService{
	@Autowired
	private ManagerLogDao managerLogDao;
	@Autowired
	private ManagerDao managerDao;
	@Override
	public Integer createManagerLog(Integer id, ManagerLogEnum managerLogEnum) {
		// 生成删除用户日志
		ManagerInfo currentManager = getCurrentManager();
		ManagerLog managerLog = new ManagerLog();
		managerLog.setMlogManagerId(currentManager.getManagerId());
		managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
		managerLog.setMlogContent(currentManager.getManagerAccount()+managerLogEnum.getContent() + id);
		managerLog.setMlogType(managerLogEnum.getType());
		managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
		return managerLogDao.createManagerLog(managerLog);
	}
	/**
	 * 获取当前用户 登录之后，ManagerInfo不会为空
	 * 
	 * @return
	 */
	private ManagerInfo getCurrentManager() {
		String currentUser = (String) SecurityUtils.getSubject().getPrincipal();
		ManagerInfo managerInfo = null;
		if (currentUser != null) {
			managerInfo = managerDao.findByManagerAccount(currentUser);
		}
		return managerInfo;
	}
}
