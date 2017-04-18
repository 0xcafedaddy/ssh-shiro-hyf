package com.whitehorse.qingzhi.web.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.result.ResultFactory;
import com.whitehorse.qingzhi.result.ResultInfo;


/**
* @author hyf
* @date 2017年4月6日
* @description 
*/
@ControllerAdvice
public class DefaultExceptionHandler {
	/**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ResultInfo processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        
    	ResultInfo resultInfo = ResultFactory.getInstance(Constants.NOAUTH_CODE, null);
    	
        return resultInfo;
    }
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ResultInfo requestParamException(Exception exception, WebRequest request){  
    	
    	ResultInfo resultInfo = ResultFactory.getInstance(Constants.PARAM_ERRORCODE, null);
    	
    	return resultInfo;
    	
    }
}
