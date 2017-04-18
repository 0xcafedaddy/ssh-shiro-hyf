package com.whitehorse.qingzhi.shiro.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.service.ManagerService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private ManagerService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByManagerAccount(username));
        return true;
    }
}
