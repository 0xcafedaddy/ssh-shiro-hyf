package com.whitehorse.qingzhi.entity;
/**
* @author hyf
* @date 2017年4月12日
* @description 
*/
public enum GenderEnum {
	NOKNOW(0,"未知"),MAN(1,"男"),WOMAN(2,"女");
	private int gender;
	private String genderInfo;
	private GenderEnum(int gender, String genderInfo) {
		this.gender = gender;
		this.genderInfo = genderInfo;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getGenderInfo() {
		return genderInfo;
	}
	public void setGenderInfo(String genderInfo) {
		this.genderInfo = genderInfo;
	}
	
	
}
