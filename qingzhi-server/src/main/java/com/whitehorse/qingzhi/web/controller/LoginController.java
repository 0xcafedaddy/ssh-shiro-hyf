package com.whitehorse.qingzhi.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;
import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.result.Content;
import com.whitehorse.qingzhi.result.ResultFactory;
import com.whitehorse.qingzhi.result.ResultInfo;
import com.whitehorse.qingzhi.service.PasswordHelper;
import com.whitehorse.qingzhi.service.ManagerService;

import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hyf
 * @date 2017年4月5日
 * @description 相关配置
 */
@Controller
public class LoginController {
	@Autowired
	private ManagerService managerService;
	private ResultInfo resultInfo = null;

	@RequestMapping(value = "/login")
	public @ResponseBody ResultInfo showLoginForm(HttpServletRequest req, Model model) {
		try {
			String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");

			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {// 账号错误
				resultInfo = ResultFactory.getInstance(Constants.USERNAME_ERRORCODE, null);

			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {// 密码错误
				resultInfo = ResultFactory.getInstance(Constants.PASSWORD_ERRORCODE, null);

			} else if (exceptionClassName == null) { // 需要登录验证
				resultInfo = ResultFactory.getInstance(Constants.NOLOGIN_ERRORCODE, null);

			} else if (AuthenticationException.class.getName().equals(exceptionClassName)) {// 参数不正确

				resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
			} else {// 其他
				resultInfo = ResultFactory.getInstance(Constants.ELSE_ERRORCODE, null);

			}
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}

		return resultInfo;
	}

	@RequestMapping(value = "/success")
	public @ResponseBody ResultInfo loginSuccess(HttpServletRequest req, Model model) {

		try {
			String userAccount = (String) SecurityUtils.getSubject().getPrincipal();

			ManagerInfo manager = managerService.findByManagerAccount(userAccount);

			resultInfo = ResultFactory.getInstance(Constants.SUCCESS_FLAG, manager);
		} catch (Exception e) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}

		return resultInfo;
	}

	@RequestMapping(value = "/unauthorized")
	public @ResponseBody ResultInfo unauthorized(HttpServletRequest req, UnauthorizedException e) {
		try {
			resultInfo = ResultFactory.getInstance(Constants.NOAUTH_CODE, null);
		} catch (Exception e2) {
			resultInfo = ResultFactory.getInstance(Constants.EXCEPTION_CODE,null);
		}

		return resultInfo;

	}

}
