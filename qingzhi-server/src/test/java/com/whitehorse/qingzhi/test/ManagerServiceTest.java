package com.whitehorse.qingzhi.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import com.whitehorse.qingzhi.dao.ManagerDao;
import com.whitehorse.qingzhi.dao.ManagerLecturerDao;
import com.whitehorse.qingzhi.entity.ManagerAuth;
import com.whitehorse.qingzhi.entity.ManagerInfo;
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
public class ManagerServiceTest {
	@Autowired
	private ManagerService managerService;
	private int currentTime ;
	private String super_admin = "hyf_admin";
	private String teacher_admin = "teacher_admin";
	private String page_admin = "page_admin";
	
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private ManagerLecturerDao managerLecturerDao;
	@Before
	public void beforeExcute(){
		currentTime = (int)(System.currentTimeMillis()/1000);
	}
	
	@Test
	public void testFindUserByInfo(){
		
		ManagerInfo user = managerService.findByManagerAccount(super_admin);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserById(){
		
		ManagerInfo user = managerDao.findByManagerId(1);
		System.out.println(user.getManagerName());
	}
	@Test
	public void testFindByGrade(){
		
		List<ManagerInfo> userList = managerDao.findByGrade(1);
		System.out.println(userList.size());
	}
	/**
	 * 创建用户测试
	 */
	@Test
	public void testCreateUser(){
		ManagerInfo mManagerInfo = new ManagerInfo();
    	mManagerInfo.setManagerAccount(super_admin+"aa");
    	mManagerInfo.setManagerPassword("123456");
    	mManagerInfo.setManagerName("teachera");
    	mManagerInfo.setManagerCreateTime(currentTime);
    	mManagerInfo.setManagerUpdateTime(currentTime);
    	mManagerInfo.setManagerCreateIp(111111);
    	mManagerInfo.setManagerGrade(4);
    	mManagerInfo.setManagerStatus(0);
    	mManagerInfo.setManagerIsDelete(false);
    	System.out.println(managerService.createManagerInfo(mManagerInfo));
		
		
	}
	@Test
	public void testDeleteUser(){
		//需要登录测试
		//int a = managerService.deleteManager(super_admin);
		try {
			int a = managerService.deleteManager(super_admin+"aa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	@Test
	public void testAddAuth(){
		//需要登录测试
		int a = managerService.addAuth(teacher_admin, "teacher:*", "/qingzhi/*/teacher/**");
		System.out.println(a);
	}
	
	@Test
	public void addLecturer(){
		//需要登录测试
		/*int a  = managerService.addLecturer(1, 1,"ceshi" ,1111111);
		System.out.println(a);*/
	}
	@Test
	public void deleteUserById(){
		
	}
	@Test
	public void findLecturerIdById(){
		List<Integer>  aa  = managerLecturerDao.findLecturerIdById(1);
		System.out.println(Arrays.toString(aa.toArray()));
	}
	@Test
	public void findByElseId(){
		List<ManagerInfo>  aa  = managerService.findManagerByElseId(2);
		System.out.println(Arrays.toString(aa.toArray()));
	}
	@Test
	public void findIdsByElseId(){
		List<Integer>  aa  = managerLecturerDao.findAllLecturerIds();
		System.out.println(Arrays.toString(aa.toArray()));
	}
}
