package com.whitehorse.qingzhi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whitehorse.qingzhi.entity.GenderEnum;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.entity.UserBaseInfo;
import com.whitehorse.qingzhi.service.PasswordHelper;
import com.whitehorse.qingzhi.service.UserService;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.shiro.spring.SpringUtils;

/**
* @author hyf
* @date 2017年4月5日
* @description 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;
	private int currentTime ;
	@Before
	public void beforeExcute(){
		currentTime = (int)(System.currentTimeMillis()/1000);
	}
	@Test
	public void createUser(){
		
		UserBaseInfo user = new UserBaseInfo();
		user.setUserCity("南京");
		user.setUserCreateIp(11111111);
		user.setUserCreateTime(currentTime);
		user.setUserHeadImage("/sas/sa");
		user.setUserIsDelete(false);
		user.setUserIsLecturer(false);
		user.setUserNickname("测试员ssaa");
		user.setUserProvince("江苏省");
		user.setUserSex(GenderEnum.MAN.getGender());
		user.setUserStatus(0);
		user.setUserWxOpenid("12ssaaa");
		user.setUserUpdateTime(currentTime);
		int a = userService.createUser(user);
		System.out.println(a);
	}
	@Test
	public void findUserByName(){
		List<UserBaseInfo> user = userService.findUserByUserName("测试员");
		System.out.println(user);
	}
	@Test
	public void deleteUserById(){
		int a = userService.deleteUserById(1);
		System.out.println(a);
	}
	
	@Test
	public void findUserByPage(){
		List<UserBaseInfo> a = userService.findUserByPage(1, 2);
		System.out.println(a.size());
	}
	
	@Test
	public void findByWXId(){
		UserBaseInfo user = userService.findByOpenId("123sa");
		System.out.println(user);
	}
}
