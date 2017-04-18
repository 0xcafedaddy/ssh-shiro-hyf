package com.whitehorse.qingzhi.shiro.realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.whitehorse.qingzhi.Constants;
import com.whitehorse.qingzhi.entity.ManagerInfo;
import com.whitehorse.qingzhi.service.AuthorizationService;
import com.whitehorse.qingzhi.service.ManagerService;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService userService;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        
        
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        ManagerInfo managerInfo = userService.findByManagerAccount(username);
        
        if(managerInfo==null){
        	//此账户已删除的情况
        	
        }else{
        	String auth = managerInfo.getManagerAuth();
        	if(!StringUtils.isEmpty(auth)){
            	Set<String> permissions = JSON.parseObject(auth).keySet();
            	authorizationInfo.setStringPermissions(permissions);
            }
        }
        
        /*authorizationInfo.setRoles(authorizationService.findRoles(Constants.SERVER_APP_KEY, username));*/
        
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        ManagerInfo managerInfo = userService.findByManagerAccount(username);
        if(username==null){
        	throw new AuthenticationException();//没找到帐号
        }
        if(managerInfo == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        /*if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/
        String salt = managerInfo.getManagerAccount()+managerInfo.getManagerName();
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		managerInfo.getManagerAccount(), //用户名
        		managerInfo.getManagerPassword(), //密码
                ByteSource.Util.bytes(managerInfo.obtainCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        /*SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		user.getUsername(), //用户名
        		user.getPassword(), //密码
        		getName()  //realm name
        		);*/
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
