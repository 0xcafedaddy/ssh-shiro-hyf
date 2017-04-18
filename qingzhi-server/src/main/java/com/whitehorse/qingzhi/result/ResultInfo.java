package com.whitehorse.qingzhi.result;

/**
 * @author hyf
 * @date 2017年4月10日
 * @description
 */
public class ResultInfo {
	
	private int code = 200;
	
	private Content content;

	
	public ResultInfo(Content content) {
		
		this.content = content;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
	

	
}
