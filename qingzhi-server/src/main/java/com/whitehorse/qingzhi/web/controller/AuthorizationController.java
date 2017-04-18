package com.whitehorse.qingzhi.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.service.AppService;
import com.whitehorse.qingzhi.service.AuthorizationService;
import com.whitehorse.qingzhi.service.ManagerService;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
@Controller
@RequestMapping(Constants.QINGZHI+"/authorization")
public class AuthorizationController {

    

}
