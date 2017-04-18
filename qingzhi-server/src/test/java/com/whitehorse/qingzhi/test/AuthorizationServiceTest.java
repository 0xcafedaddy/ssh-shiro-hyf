package com.whitehorse.qingzhi.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.ManagerAuth;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.service.AuthorizationService;
import com.whitehorse.qingzhi.service.PasswordHelper;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.shiro.spring.SpringUtils;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class AuthorizationServiceTest {
	@Autowired
	private AuthorizationService authorizationService;
	
	private int currentTime ;
	@Before
	public void beforeExcute(){
		currentTime = (int)(System.currentTimeMillis()/1000);
	}
	
	@Test
	public void testCreateAuth(){
		ManagerAuth managerAuth = new ManagerAuth();
		managerAuth.setMauthCreateTime(currentTime);
		managerAuth.setMauthIsDelete(false);
		managerAuth.setMauthName("teacher:update");
		managerAuth.setMauthStatus(0);
		managerAuth.setMauthUrl("/teacher/update"+Constants.QINGZHI_VERSION);
		int a = authorizationService.createAuthorization(managerAuth);
		System.out.println(a);
		
	}
	@Test
	public void testFindAuthByName(){
		List<ManagerAuth> aList = authorizationService.findAuthByName("*");
		System.out.println(aList);
		
	}
	@Test
	public void testFindAll(){
		List<ManagerAuth> aList = authorizationService.findAll();
		System.out.println(aList);
		
	}
}
