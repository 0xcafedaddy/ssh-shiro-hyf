package com.whitehorse.qingzhi.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public class ServerFormAuthenticationFilter extends FormAuthenticationFilter {
	
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		
		WebUtils.redirectToSavedRequest(request, response, getSuccessUrl());
		
		
	}
	
}
