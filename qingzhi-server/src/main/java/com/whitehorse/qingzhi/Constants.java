package com.whitehorse.qingzhi;
/**
* @author hyf
* @date 2017年4月5日
* @description 相关配置
*/
public class Constants {
	public static final String CURRENT_USER = "user";

    public static final String SERVER_APP_KEY = "645ba616-370a-43a8-a8e0-993e7a590cf0";
    //当前版本
    public static final String QINGZHI_VERSION = "/v1";
    //
    public static final String QINGZHI = "qingzhi";
    //超级管理员
    public static final String SUPER_MANAGER = "/**";
    //讲师管理员
    public static final String TEACHER_MANAGER = "/teacher/"+QINGZHI_VERSION+"/**";
    //页面管理员
    public static final String PAGE_MANAGER = "";
    //其他管理员
    public static final String ELSE_MANAGER = "";
    
    
    public static final int MAX_MANAGER_LECTURER_COUNT = 10;
    
   
    
    //接口调用成功
    public static final int SUCCESS_FLAG = 1;
    /**
     * 500+错误码
     */
    public static final int ERROR_CODE = 500;
    
    //参数错误
    public static final String PARAM_ERROR = "参数不正确";
    public static final int PARAM_ERRORCODE = 5000;
    
    //地址错误
    public static final String URL_ERROR = "地址不正确";
    public static final int URL_ERRORCODE = 5003;
    
    //其他错误
    public static final String ELSE_ERROR= "其他错误";
    public static final int ELSE_ERRORCODE= 000;
    
    //账号或密码错误
    public static final String LOGIN_ERROR = "账号或密码错误";
    public static final int LOGIN_ERRORCODE= 100;
    
    //账号不存在
    public static final String USERNAME_ERROR = "账号不存在";
    public static final int USERNAME_ERRORCODE = 101;
    
    //密码不正确
    public static final String PASSWORD_ERROR = "密码不正确";
    public static final int PASSWORD_ERRORCODE = 102;
    
    //需要登录
    public static final String NOLOGIN_ERROR = "需要登录";
    public static final int NOLOGIN_ERRORCODE = 011;
    
    //没有权限
    public static final String NOAUTH_ERROR = "没有权限";
    public static final int NOAUTH_CODE = 401;
    
    //管理员讲师超过10个
    public static final String MANAGER_LECTURER_OUT_ERROR = "管理讲师数量超限";
    public static final int MANAGER_LECTURER_OUT_CODE = 402;
    
    
    
    //出现异常
    public static final String EXCEPTION_ERROR = "未捕获异常";
    public static final int EXCEPTION_CODE = 555;
    
    
    
    
   
   
    
    
}
