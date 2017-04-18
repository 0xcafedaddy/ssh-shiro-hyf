package com.whitehorse.qingzhi.service;


import java.util.List;

import com.whitehorse.qingzhi.entity.App;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public interface AppService {


    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    /**
     * 根据appKey查找AppId
     * @param appKey
     * @return
     */
    public Long findAppIdByAppKey(String appKey);
}
