package com.whitehorse.qingzhi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.alibaba.druid.util.StringUtils;
import com.whitehorse.qingzhi.entity.ManagerAuth;

/**
* @author hyf
* @date 2017年4月14日
* @description 
*/
public class SmallTest {

	
	@Test
	public void testComapra(){
		List<ManagerAuth> aaa = new ArrayList<ManagerAuth>();
		ManagerAuth a = new ManagerAuth();
		ManagerAuth b = new ManagerAuth();
		ManagerAuth c = new ManagerAuth();
		ManagerAuth d = new ManagerAuth();
		ManagerAuth e = new ManagerAuth();
		a.setMauthName("teacher:delete");
		b.setMauthName("teacher:*");
		c.setMauthName("teacher:update");
		d.setMauthName("uesr:*");
		e.setMauthName("uesr:update");
		e.setMauthName("*");
		aaa.add(a);
		aaa.add(b);
		aaa.add(c);
		aaa.add(d);
		aaa.add(e);
		for(ManagerAuth axs: aaa){
			System.out.print(axs.getMauthName()+",");
		}
		System.out.println("");
		Collections.sort(aaa);
		System.out.println("===============");
		for(ManagerAuth axs: aaa){
			System.out.print(axs.getMauthName()+",");
		}
		System.out.println("");
		
	}
	@Test
	public void isEmpty(){
		String a = "";
		System.out.println(StringUtils.isEmpty(a));
	}

}
