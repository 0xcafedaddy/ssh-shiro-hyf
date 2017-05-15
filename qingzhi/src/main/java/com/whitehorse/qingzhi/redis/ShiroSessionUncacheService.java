package com.whitehorse.qingzhi.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whitehorse.qingzhi.shiro.session.cluster.CachingShiroSessionDao;
import com.whitehorse.qingzhi.shiro.session.cluster.CachingShiroSessionDao;

public class ShiroSessionUncacheService implements PubSubService {

    private static final Logger logger = LoggerFactory.getLogger(ShiroSessionUncacheService.class);

    @Autowired
    CachingShiroSessionDao sessionDao;

    @Override
    public void handle(String channel, String message) {
        logger.debug("channel {} , message {} ", channel, message);
        sessionDao.uncache(message);
    }
}