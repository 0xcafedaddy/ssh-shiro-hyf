package com.whitehorse.qingzhi.result;
/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public class Content {
	
	private boolean is_sussess;
	
	private Integer error_code;
	
	private String error; 
	
	private Object result;

	public Content(boolean is_sussess, Integer error_code, String error, Object result) {
		super();
		this.is_sussess = is_sussess;
		this.error_code = error_code;
		this.error = error;
		this.result = result;
	}

	public boolean isIs_sussess() {
		return is_sussess;
	}

	public void setIs_sussess(boolean is_sussess) {
		this.is_sussess = is_sussess;
	}

	public Integer getError_code() {
		return error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	
	
}
