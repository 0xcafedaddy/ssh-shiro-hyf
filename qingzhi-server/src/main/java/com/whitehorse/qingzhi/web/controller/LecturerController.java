package com.whitehorse.qingzhi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.LecturerInfo;
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.entity.UserBaseInfo;
import com.whitehorse.qingzhi.result.ResultFactory;
import com.whitehorse.qingzhi.result.ResultInfo;
import com.whitehorse.qingzhi.service.LecturerService;
import com.whitehorse.qingzhi.service.ManagerLecturerService;
import com.whitehorse.qingzhi.service.ManagerLogService;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.service.UserService;

/**
* @author hyf
* @date 2017年4月13日
* @description 
*/
@Controller
@RequestMapping(Constants.QINGZHI +"/lecturer")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	@Autowired
	private ManagerLecturerService managerLecturerService;
    
	@Autowired
	private ManagerLogService managerLogService;
	
	@Autowired
	private UserService userService;
	
	
	
	
    private ResultInfo resultInfo;
    
    
    /**
     * 根据管理员id查询其讲师
     * @param managerId
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/findByManagerId",method=RequestMethod.GET)
    public @ResponseBody ResultInfo addManagerLecturer(Integer managerId){
    	try {
    		if(StringUtils.isEmpty(String.valueOf(managerId))){
        		resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
        	}else{
        		List<Integer> ids = managerLecturerService.findLecturersByIds(managerId);
        		List<LecturerInfo> lecturerInfoList = null;
        		if(ids.size()>0){
        			lecturerInfoList = lecturerService.findLecturersByIds(ids);	
        		}
        		resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, lecturerInfoList);
        	}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}
    	
    	
		return resultInfo;
    	
    }
    
    /**
     * 根据管理员讲师 id 删除管理员讲师
     * @param managerId
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/deleteByLectureId",method=RequestMethod.DELETE)
    public @ResponseBody ResultInfo deleteManagerLecturer(@RequestBody String data){
    	try {
    		JSONObject jb = JSON.parseObject(data);
        	Integer managerLecturerId = jb.getInteger("managerLecturerId");
        	
        	if(StringUtils.isEmpty(String.valueOf(managerLecturerId))){
        		
        		resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
        	}else{
        		int result = managerLecturerService.deleteManagerLecturerById(managerLecturerId);
        		if(result == 0){
        			resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);
        		}else{
        			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "删除成功");
        		}
        		
        	}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}
    	
		return resultInfo;
    	
    }
    
    /**
     * 根据讲师id删除讲师
     * @param lecturerId
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/deleteLecturerById",method=RequestMethod.DELETE)
    public @ResponseBody ResultInfo deleteLecturer(@RequestBody String data){
    	try {
    		JSONObject jb = JSON.parseObject(data);
    		
        	Integer lecturerId = jb.getInteger("lecturerId");
        	
    		if(StringUtils.isEmpty(String.valueOf(lecturerId))){
        		
        		resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
        	}else{
        		int result = lecturerService.deleteLecture(lecturerId);
        		if(result == 0){
        			resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);
        		}else{
        			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "讲师删除成功");
        			//添加删除讲师日志
        			managerLogService.createManagerLog(lecturerId,ManagerLogEnum.DELETEALL_LECTURER);
        			
        		}
        		
        	}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}
    	
		return resultInfo;
    	
    }
    /**
     * 获取所有没有管理员的讲师
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/findLecturerNoManager",method=RequestMethod.GET)
    public @ResponseBody ResultInfo findLecturerNoManager(){
    	try {
    		List<Integer> ids = managerLecturerService.findAllLecturerIds();
    		
    		
    		if(ids.size() == 0){
    			
    			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, null);
    		}else{
    			List<LecturerInfo>  lecturerList = lecturerService.findLecturersByNoIds(ids);
    			
    			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, lecturerList);
    			
    		}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}
    	
		return resultInfo;
    	
    }
    /**
     * 根据微信id获取用户信息
     * @param userWxOpenid
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/findUserByOpenId",method=RequestMethod.GET)
    public @ResponseBody ResultInfo findUserByOpenId(String userWxOpenid){
    	try {
    		if(StringUtils.isEmpty(String.valueOf(userWxOpenid))){
    			
    			resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
    			
    		}else{
    			UserBaseInfo  userBaseInfo  = userService.findByOpenId(userWxOpenid);
    			
    			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, userBaseInfo);
    		}
    		
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}
    	
		return resultInfo;
    	
    }
    
    /**
     * 讲师管理员创建一个讲师并由自己管理
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/addLecturer",method=RequestMethod.PUT)
    public @ResponseBody ResultInfo addLecturer(@RequestBody String data){
    	try {
    		LecturerInfo lecturerInfo  = JSON.parseObject(data, LecturerInfo.class);
    		
    		if(lecturerInfo == null){
    			resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
    		}else{
    			
    			
    		}
    		
    		
    		
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}
    	
		return resultInfo;
    	
    }
}
