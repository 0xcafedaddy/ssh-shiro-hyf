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
import com.whitehorse.qingzhi.entity.ManagerLogEnum;
import com.whitehorse.qingzhi.entity.UserBaseInfo;
import com.whitehorse.qingzhi.result.ResultFactory;
import com.whitehorse.qingzhi.result.ResultInfo;
import com.whitehorse.qingzhi.service.ManagerLogService;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.service.UserService;

/**
* @author hyf
* @date 2017年4月13日
* @description 
*/
@Controller
@RequestMapping(Constants.QINGZHI+"/user")
public class UserController {
	@Autowired
	private ManagerLogService managerLogService;
    
	@Autowired
    private UserService userService;
	
    private ResultInfo resultInfo;
    
    /**
     * 管理员删除用户并记录日志
     * @param info
     * @return
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/deleteManagerUser",method=RequestMethod.DELETE)
    public @ResponseBody ResultInfo deleteManagerUser(@RequestBody String info){
    	
    	JSONObject jb = JSON.parseObject(info);
    	Integer userId = jb.getInteger("userId");
    	if(StringUtils.isEmpty(String.valueOf(userId))){
    		resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
    	}else{
    		int result = userService.deleteUserById(userId);
    		
    		if( result == 0 ){
    			
    			resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);
    			
    		}else{
    			//创建删除日志
    			managerLogService.createManagerLog(userId,ManagerLogEnum.DELETE_USER);
    			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, "用户删除成功");
    		}
    	}
    	
		return resultInfo;
    	
    }
    
    /**
     * 分页查询所有用户
     */
    @RequestMapping(value=Constants.QINGZHI_VERSION +"/findManagerUserByPage",method=RequestMethod.GET)
    public @ResponseBody ResultInfo findManagerUser(Integer page,Integer size){
    	
    	if(StringUtils.isEmpty(String.valueOf(page))||StringUtils.isEmpty(String.valueOf(size))){
    		resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
    	}else{
    		List<UserBaseInfo> result = userService.findUserByPage(page, size);
    			
    		resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, result);
    	}
    	
		return resultInfo;
    	
    }
}
