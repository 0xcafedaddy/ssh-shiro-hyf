package com.whitehorse.qingzhi.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.dao.ManagerDao;
import com.whitehorse.qingzhi.dao.ManagerLecturerDao;
import com.whitehorse.qingzhi.dao.ManagerLogDao;
import com.whitehorse.qingzhi.dao.UserDao;
import com.whitehorse.qingzhi.datasource.DataSourceKey;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLecturer;
import com.whitehorse.qingzhi.entity.ManagerLog;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.service.PasswordHelper;
import com.whitehorse.qingzhi.service.UserService;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.utils.TimeUtil;

import java.util.*;

/**
 * @author hyf
 * @date 2017年4月11日
 * @description
 */
@Service
@DataSourceKey("dataSourceAdmin")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private ManagerLogDao managerLogDao;
	
	@Autowired
	private ManagerLecturerDao managerLecturerDao;
	
	@Autowired
	private PasswordHelper passwordHelper;

	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionDAO sessionDAO;

	
	@Override
	public ManagerInfo findByManagerAccount(String userAccount) {

		return managerDao.findByManagerAccount(userAccount);
	}

	@Override
	public Integer createManagerInfo(ManagerInfo managerInfo) {
		passwordHelper.encryptPassword(managerInfo);// 密码加密
		if(managerInfo.getManagerGrade()==0){
			JSONObject auth = new JSONObject();
	    	auth.put("*", Constants.SUPER_MANAGER);
	    	String acthStr = JSON.toJSONString(auth);
	    	managerInfo.setManagerAuth(acthStr);
		}
		int managerInfoId = managerDao.createManagerInfo(managerInfo);
		if(managerInfoId!=-1){
			// 生成创建日志
			ManagerLog managerLog = new ManagerLog();
			managerLog.setMlogManagerId(managerInfoId);
			managerLog.setMlogCreateIp(managerInfo.getManagerCreateIp());
			managerLog.setMlogContent(ManagerLogEnum.CREATE_MANAGER.getContent());
			managerLog.setMlogType(ManagerLogEnum.CREATE_MANAGER.getType());
			managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
			managerLogDao.createManagerLog(managerLog);
		}
		return managerInfoId;
	}

	@Override
	public Integer deleteManager(String userAccount) {
		
		ManagerInfo managerInfo = managerDao.findByManagerAccount(userAccount);
		Integer num = managerDao.deleteManager(userAccount);
		if (num == 0) {
			return num;
		}
		ManagerInfo currentManager = getCurrentManager();
		// 踢出会话
		deleteSessionByUsername(userAccount);
		
		// 生成删除管理员的日志
		ManagerLog managerLog = new ManagerLog();
		managerLog.setMlogManagerId(currentManager.getManagerId());
		managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
		managerLog.setMlogContent(ManagerLogEnum.DELETE_MANAGER.getContent() + userAccount);
		managerLog.setMlogType(ManagerLogEnum.DELETE_MANAGER.getType());
		managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
		int managerLogId = managerLogDao.createManagerLog(managerLog);
		if(managerLogId==0){
			return managerLogId;
		}
		//删除其拥有的所有讲师
		int result = managerLecturerDao.deleteManagerLecturer(managerInfo.getManagerId());
		if(result==0){
			return result;
		}
		
		//生成删除管理员管理的讲师日志
		ManagerLog managerLogT = new ManagerLog();
		managerLogT.setMlogManagerId(currentManager.getManagerId());
		managerLogT.setMlogCreateIp(currentManager.getManagerCreateIp());
		managerLogT.setMlogContent(currentManager.getManagerName()+ ManagerLogEnum.DELETEALL_MANAGER_LECTURER.getContent() + managerInfo.getManagerAccount());
		managerLogT.setMlogType(ManagerLogEnum.DELETEALL_MANAGER_LECTURER.getType());
		managerLogT.setMlogCreateTime(TimeUtil.getCurrentTime());
		int managerLogIdT= managerLogDao.createManagerLog(managerLogT);
		
		return managerLogIdT;
	}

	@Override
	public Integer addAuth(String account,String authName,String authUrl) {


		ManagerInfo managerInfo = managerDao.findByManagerAccount(account);

		if (managerInfo == null) {
			return 0;
		}
		// 转换为类
		JSONObject jb = JSONObject.parseObject(managerInfo.getManagerAuth());
		if (jb == null) {
			jb = new JSONObject();
		}

		jb.put(authName, authUrl);

		String authNew = jb.toJSONString();

		Integer num = managerDao.addAuth(account, authNew);

		if (num != 0) { // 生成添加权限日志
			ManagerInfo currentManager = getCurrentManager();
			ManagerLog managerLog = new ManagerLog();
			managerLog.setMlogManagerId(currentManager.getManagerId());
			managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
			managerLog.setMlogContent("为"+ account + ManagerLogEnum.ADD_AUTH.getContent() + authName);
			managerLog.setMlogType(ManagerLogEnum.ADD_AUTH.getType());
			managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
			managerLogDao.createManagerLog(managerLog);
		}

		return num;
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

	/**
	 * 踢出已被删除的用户
	 * 
	 * @param useraccount
	 */
	private void deleteSessionByUsername(String useraccount) {

		Collection<Session> sessions = sessionDAO.getActiveSessions();

		for (Session session : sessions) {

			if (useraccount
					.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {

				session.setTimeout(1000);// 设置session立即失效，即将其踢出系统

				break;
			}
		}
	}

	@Override
	public ManagerInfo findByManagerId(Integer id) {
		
		return managerDao.findByManagerId(id);
	}

	@Override
	public List<ManagerInfo> findManagerByElseId(Integer managerId) {
		
		return managerDao.findManagerByElseId(managerId);
	}
}
