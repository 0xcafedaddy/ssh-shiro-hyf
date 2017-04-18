package com.whitehorse.qingzhi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.result.ResultFactory;
import com.whitehorse.qingzhi.result.ResultInfo;
import com.whitehorse.qingzhi.service.AuthorizationService;
import com.whitehorse.qingzhi.web.bind.annotation.CurrentUser;

import java.util.List;
import java.util.Set;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
@Controller
public class IndexController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/")
    @ResponseBody
    public String index(@CurrentUser ManagerInfo loginUser, Model model) {
        /*Set<String> permissions = authorizationService.findPermissions(Constants.SERVER_APP_KEY, loginUser.getManagerName());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);*/
        return "成功了";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    
    @RequestMapping("/test")
    public @ResponseBody ResultInfo requestUrlException(Exception exception, WebRequest request){  
    	
    	ResultInfo resultInfo = ResultFactory.getInstance(Constants.URL_ERRORCODE, null);
    	
    	return resultInfo;
    	
    }

}
