package com.whitehorse.qingzhi.result;

import com.whitehorse.qingzhi.Constants;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public class ResultFactory {
	
	
	
	
	/**
	 * 返回模板
	 * @return
	 */
	public static ResultInfo getInstance(Integer code,Object obj){
		Content content = new Content(false, null, null, null);
		
		ResultInfo resultInfo = new ResultInfo(content);
		
		switch (code) {
		//参数错误
		case Constants.PARAM_ERRORCODE:
			resultInfo.setCode(Constants.ERROR_CODE);
			content.setError_code(code);
			content.setError(Constants.PARAM_ERROR);
			break;
		//请求地址错误
		case Constants.URL_ERRORCODE:
			resultInfo.setCode(Constants.ERROR_CODE);
			content.setError_code(code);
			content.setError(Constants.URL_ERROR);
			break;
		//账号或密码错误	
		case Constants.LOGIN_ERRORCODE:
			content.setError_code(code);
			content.setError(Constants.LOGIN_ERROR);
			break;
		//账号不存在
		case Constants.USERNAME_ERRORCODE:
        	content.setError_code(code);
        	content.setError(Constants.USERNAME_ERROR);
			break;
		//密码不存在
		case Constants.PASSWORD_ERRORCODE:
        	content.setError_code(code);
        	content.setError(Constants.PASSWORD_ERROR);
			break;
		//未登录
		case Constants.NOLOGIN_ERRORCODE:
        	content.setError_code(code);
        	content.setError(Constants.NOLOGIN_ERROR);
			break;
		//无权限
		case Constants.NOAUTH_CODE:
        	content.setError_code(code);
        	content.setError(Constants.NOAUTH_ERROR);
			break;
		//未知错误
		case Constants.ELSE_ERRORCODE:
        	content.setError_code(code);
        	content.setError(Constants.ELSE_ERROR);
			break;
			
		//请求成功
		default:
			content.setIs_sussess(true);
			content.setResult(obj);
			break;
		}
		return resultInfo;
	}
}
