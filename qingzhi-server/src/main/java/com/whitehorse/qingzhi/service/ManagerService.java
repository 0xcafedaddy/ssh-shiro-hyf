package com.whitehorse.qingzhi.service;



import java.util.List;

import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.ManagerLecturer;
import com.whitehorse.qingzhi.entity.ManagerLog;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public interface ManagerService {
	/**
	 * 添加管理员
	 * @param managerInfo
	 * @return
	 */
    
    Integer createManagerInfo(ManagerInfo managerInfo);


    /**
     * 根据用户名查找管理员
     * @param username
     * @return
     */
    ManagerInfo findByManagerAccount(String userAccount);
    
    /**
     * 根据id查找管理员
     * @param username
     * @return
     */
    ManagerInfo findByManagerId(Integer id);

    /**
	 * 根据账号删除管理员
	 * @param userAccount
	 * @return
	 */
	Integer deleteManager(String userAccount); 
	
	/**
     * 给某管理员添加权限
     * @param anthId
     * @param authName
     * @return
     */
    Integer addAuth(String account,String authName,String authUrl);
    
    /**
     * 根据管理员ID，获取其他讲师的管理员(配合修改讲师管理员使用)
     * @param mamagerId
     * @return
     */
    List<ManagerInfo> findManagerByElseId(Integer managerId);
    
}
