package com.whitehorse.qingzhi.service;

import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.whitehorse.qingzhi.entity.ManagerAuth;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroFilerChainManager {

    @Autowired
    private DefaultFilterChainManager filterChainManager;

    private Map<String, NamedFilterList> defaultFilterChains;

    @PostConstruct
    public void init() {
        defaultFilterChains = new HashMap<String, NamedFilterList>(filterChainManager.getFilterChains());
    }

    /**
     * 动态添加权限
     * @param urlFilters
     */
    public void initFilterChains(List<ManagerAuth> urlFilters) {
        //1、首先删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if(defaultFilterChains != null) {
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }

        //2、循环URL Filter 注册filter chain
        for (ManagerAuth urlFilter : urlFilters) {
            String url = urlFilter.getMauthUrl();
            //注册roles filter
            /*if (!StringUtils.isEmpty(urlFilter.getRoles())) {
                filterChainManager.addToChain(url, "roles", urlFilter.getRoles());
            }*/
            //注册perms filter
            if (!StringUtils.isEmpty(urlFilter.getMauthName())) {
                filterChainManager.addToChain(url, "perms", urlFilter.getMauthName());
            }
        }


    }

}
