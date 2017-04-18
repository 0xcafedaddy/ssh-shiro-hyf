package com.whitehorse.qingzhi.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.dao.ManagerDao;
import com.whitehorse.qingzhi.dao.ManagerLecturerDao;
import com.whitehorse.qingzhi.dao.ManagerLogDao;
import com.whitehorse.qingzhi.datasource.DataSourceKey;
import com.whitehorse.qingzhi.entity.LecturerInfo;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLecturer;
import com.whitehorse.qingzhi.entity.ManagerLog;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.service.ManagerLecturerService;
import com.whitehorse.qingzhi.utils.TimeUtil;

/**
* @author hyf
* @date 2017年4月17日
* @description 
*/
@Service
@DataSourceKey("dataSourceAdmin")
public class ManagerLecturerServiceImpl implements ManagerLecturerService{
	@Autowired
	private ManagerLecturerDao managerLecturerDao;
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private ManagerLogDao managerLogDao;
	@Override
	public Integer addLecturer(Integer managerId, Integer lecturerId, String lecturerName, Integer ip) {
		int currentTime = (int) (System.currentTimeMillis()/1000);
		int count = managerLecturerDao.findLecturerByManagerId(managerId);
		
		if(count < Constants.MAX_MANAGER_LECTURER_COUNT){
			ManagerLecturer managerLecturer = new ManagerLecturer();
			managerLecturer.setMlCreateIp(ip);
			managerLecturer.setMlCreateTime(currentTime);
			managerLecturer.setMlLecturerId(lecturerId);
			managerLecturer.setMlManagerId(managerId);
			managerLecturer.setMlIsDelete(false);
			managerLecturer.setMlUpdateTime(currentTime);
			managerLecturer.setMlStatus(0);
			int managerLecturerId = managerLecturerDao.createLecturer(managerLecturer);
			if(managerLecturerId!=0){
				ManagerInfo currentManager = getCurrentManager();
				// 生成添加讲师日志
				ManagerLog managerLog = new ManagerLog();
				managerLog.setMlogManagerId(currentManager.getManagerId());
				managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
				managerLog.setMlogContent(currentManager.getManagerName()+ "为管理员"+managerId+ManagerLogEnum.ADD_MANAGER_LECTURER.getContent() + lecturerName);
				managerLog.setMlogType(ManagerLogEnum.ADD_MANAGER_LECTURER.getType());
				managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
				int managerLogId  = managerLogDao.createManagerLog(managerLog);
				return managerLogId;
			}else{
				return managerLecturerId;
			}
			
		}else{
			return -1;
		}
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
	@Override
	public List<Integer> findLecturersByIds(Integer id) {
		List<Integer> ids = managerLecturerDao.findLecturerIdById(id);
		return ids;
	}
	@Override
	public Integer deleteManagerLecturer(Integer managerId) {
		int result = managerLecturerDao.deleteManagerLecturer(managerId);
		if(result!=0){
			ManagerInfo currentManager = getCurrentManager();
			//生成删除管理员管理的讲师日志
			ManagerLog managerLog = new ManagerLog();
			managerLog.setMlogManagerId(currentManager.getManagerId());
			managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
			managerLog.setMlogContent(currentManager.getManagerName()+ ManagerLogEnum.DELETEALL_MANAGER_LECTURER.getContent() + managerId);
			managerLog.setMlogType(ManagerLogEnum.DELETEALL_MANAGER_LECTURER.getType());
			managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
			int managerLogId= managerLogDao.createManagerLog(managerLog);
			
			return managerLogId;
		}else{
			return 0;
		}
	}
	@Override
	public Integer deleteManagerLecturerById(Integer managerLecturerId) {
		int result = managerLecturerDao.deleteManagerLecturerById(managerLecturerId);
		if(result!=0){
			ManagerInfo currentManager = getCurrentManager();
			//生成删除管理员讲师日志
			ManagerLog managerLog = new ManagerLog();
			managerLog.setMlogManagerId(currentManager.getManagerId());
			managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
			managerLog.setMlogContent(currentManager.getManagerName()+ ManagerLogEnum.DELETE_MANAGER_LECTURER.getContent() + managerLecturerId);
			managerLog.setMlogType(ManagerLogEnum.DELETE_MANAGER_LECTURER.getType());
			managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
			int managerLogId= managerLogDao.createManagerLog(managerLog);
			
			return managerLogId;
		}else{
			return 0;
		}
	}
	@Override
	public Integer updateManagerLecturerById(Integer managerLecturerId,Integer managerId) {
		int count = managerLecturerDao.findLecturerByManagerId(managerId);
		if(count < Constants.MAX_MANAGER_LECTURER_COUNT){
			int result = managerLecturerDao.updateManagerLecturerById(managerLecturerId, managerId);
			if(result!=0){
				
				ManagerInfo currentManager = getCurrentManager();
				// 生成添加讲师日志
				ManagerLog managerLog = new ManagerLog();
				managerLog.setMlogManagerId(currentManager.getManagerId());
				managerLog.setMlogCreateIp(currentManager.getManagerCreateIp());
				managerLog.setMlogContent(currentManager.getManagerName()+ ManagerLogEnum.UPDATE_LECTURE_MANAGER.getContent() + managerLecturerId+"的管理员");
				managerLog.setMlogType(ManagerLogEnum.UPDATE_LECTURE_MANAGER.getType());
				managerLog.setMlogCreateTime(TimeUtil.getCurrentTime());
				int managerLogId= managerLogDao.createManagerLog(managerLog);
				
				return managerLogId;
			}else{
				return 0;
			}
		}else{
			return -1;
		}
	}
	@Override
	public List<Integer> findAllLecturerIds() {
		
		return managerLecturerDao.findAllLecturerIds();
	}

}
