package com.whitehorse.qingzhi.dao;



import java.util.List;

import com.whitehorse.qingzhi.entity.App;

/**
* @author hyf
* @date 2017年4月5日
* @description 负责应用的crud
*/
public interface AppDao{

	public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    Long findAppIdByAppKey(String appKey);
}
