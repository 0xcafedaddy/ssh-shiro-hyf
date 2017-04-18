package com.whitehorse.qingzhi.utils;

/**
 * @author hyf
 * @date 2017年4月12日
 * @description
 */
public class TimeUtil {

	public static Integer getCurrentTime() {

		int currentTime = (int) (System.currentTimeMillis() / 1000);

		return currentTime;
	}

}
