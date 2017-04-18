package com.whitehorse.qingzhi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.User;
import com.whitehorse.qingzhi.service.UserService;

/**
* @author hyf
* @date 2017年4月10日
* @description 
*/
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUser")
	public @ResponseBody User getUserByName(String username){
		User user = userService.findByUsername(username);
		User a = user;
		System.out.println(a);
		return a;
	}
}
