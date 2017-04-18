package com.whitehorse.qingzhi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.util.StringUtils;
import com.whitehorse.qingzhi.dao.LecturerDao;
import com.whitehorse.qingzhi.entity.LecturerInfo;
import com.whitehorse.qingzhi.entity.ManagerAuth;
import com.whitehorse.qingzhi.service.LecturerService;

/**
* @author hyf
* @date 2017年4月14日
* @description 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class LecturerServiceTest {
	@Autowired
	private LecturerDao lecturerDao;
	
	@Autowired
	private LecturerService lecturerService;
	
	private int currentTime;
	@Before
	public void beforeExcute(){
		currentTime = (int)(System.currentTimeMillis()/1000);
	}
	@Test
	public void createLecturer(){
		
		LecturerInfo lecturerInfo = new LecturerInfo();
		lecturerInfo.setLecturerName("lecturer");
		lecturerInfo.setLecturerCashPassword("123456");
		lecturerInfo.setLecturerCategoryId(0);
		lecturerInfo.setLecturerCreateTime(currentTime);
		lecturerInfo.setLecturerIncomeRatio(20.5);
		lecturerInfo.setLecturerIntroduction("");
		lecturerInfo.setLecturerMobilephone("");
		lecturerInfo.setLecturerIsDelete(false);
		lecturerInfo.setLecturerUserId(8);
		lecturerInfo.setLecturerWxName("讲师");
		lecturerInfo.setLecturerMoney(1112.4);
		lecturerInfo.setLecturerHeadImage("");
		lecturerInfo.setLecturerStatus(0);
		lecturerInfo.setLecturerUpdateTime(currentTime);
		int a = lecturerService.createLecturer(lecturerInfo);
		System.out.println(a);
	}
	
	@Test
	public void findLecById(){
		
	}
	@Test
	public void findLectureByIds(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(6);
		System.out.println(lecturerService.findLecturersByIds(ids).size());;
	}
	@Test
	public void findLectureByNoIds(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(6);
		System.out.println(lecturerService.findLecturersByNoIds(ids).size());;
	}
	@Test
	public void deleteLecture(){
		System.out.println(lecturerService.deleteLecture(1));
	}
}
