package com.whitehorse.qingzhi.remote;

import java.io.Serializable;

import org.apache.shiro.session.Session;

/**
 * @author hyf
 * @date 2017年4月5日
 * @description 远程调用接口
 */
public interface RemoteServiceInterface {

	public Session getSession(String appKey, Serializable sessionId);

	public Serializable createSession(Session session);

	public void updateSession(String appKey, Session session);

	public void deleteSession(String appKey, Session session);

	public PermissionContext getPermissions(String appKey, String username);
}
