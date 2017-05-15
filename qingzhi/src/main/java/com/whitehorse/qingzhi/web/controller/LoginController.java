package com.whitehorse.qingzhi.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whitehorse.qingzhi.redis.cluster.JedisUtil;
import com.whitehorse.qingzhi.shiro.session.cluster.CachingShiroSessionDao;
import com.whitehorse.qingzhi.shiro.session.cluster.CachingShiroSessionDao;

@Controller
public class LoginController {

	@Autowired
	private JedisUtil jedisUtil;
	
	@Autowired
	private CachingShiroSessionDao sessionDAO;
	@RequestMapping("/login")
	public String login() throws IOException {

		return "index";

	}

	@RequestMapping("/success")
	public @ResponseBody String success() {

		return "success2";
	}
	

	@RequestMapping("/fail")
	public @ResponseBody String cas() {
		Serializable sessionId = SecurityUtils.getSubject().getSession().getId();
		
		Session chcache = sessionDAO.getSession(sessionId);
		
		System.out.println("缓存中的session的id:"+chcache.getId());
		
		jedisUtil.publish("shiro.session.uncache", SecurityUtils.getSubject().getSession().getId());
		
		chcache = sessionDAO.getSession(sessionId);
		if(chcache==null)
			System.out.println("没了");
		else
			System.out.println("缓存中的session的id:"+chcache.getId());
		return "fail2";
	}
}
