package com.whitehorse.qingzhi.shiro.session.singleton;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;

import com.whitehorse.qingzhi.redis.RedisManager;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @author hyf
 * @date 2017年5月5日
 * @description
 */
public class CachingShiroSessionDao extends CachingSessionDAO {

	@Autowired
	private RedisManager redisManager;

	private String keyPrefix = "shiro_redis_session:";

	private static final Logger logger = LoggerFactory.getLogger(CachingShiroSessionDao.class);

	/**
	 * 从缓存中读取session,如果不存在或者未登录(负载均衡需要)则调用doReadSession获取session
	 */
	@Override
	public Session readSession(Serializable sessionId) throws UnknownSessionException {
		Session session = getCachedSession(sessionId);
		if (session == null || session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
			session = this.doReadSession(sessionId);
			System.out.println("查询session");
			if (session == null) {
				throw new UnknownSessionException("The redis no have session with id [" + sessionId + "]");
			} else {
				cache(session, session.getId());
			}
		} else {
			System.out.println("查询缓存session");
		}

		return session;

	}

	@Override
	protected void doUpdate(Session session) {
		if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
			return;
		}
		System.out.println("更新缓存和redis的session");
		this.saveSession(session);
	}

	@Override
	protected void doDelete(Session session) {
		System.out.println("删除了session");
		redisManager.del(this.getByteKey(session.getId()));

	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);
		assignSessionId(session, sessionId);
		this.saveSession(session);
		return sessionId;
	}

	@Override
	public Collection<Session> getActiveSessions() {
		Set<Session> sessions = new HashSet<Session>();

		Set<byte[]> keys = redisManager.keys(this.keyPrefix + "*");
		if (keys != null && keys.size() > 0) {
			for (byte[] key : keys) {
				Session s = (Session) SerializationUtils.deserialize(redisManager.get(key));
				sessions.add(s);
			}
		}

		return sessions;
	}

	/**
     * 删除cache中缓存的Session
     */
    public void uncache(Serializable sessionId) {
        try {
            Session session = super.getCachedSession(sessionId);
            super.uncache(session);
            logger.debug("shiro session id {} 的缓存失效", sessionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Session getSession(Serializable sessionId) {
    	
        Session session = super.getCachedSession(sessionId);
           
        return session;
    }
	/**
	 * 根据id获取session
	 */
	@Override
	protected Session doReadSession(Serializable sessionId) {
		Session sesseion = (Session) SerializationUtils.deserialize(redisManager.get(getByteKey(sessionId)));
		return sesseion;
	}

	/**
	 * 保存session
	 * 
	 * @param session
	 * @throws UnknownSessionException
	 */
	private void saveSession(Session session) throws UnknownSessionException {
		
		byte[] key = getByteKey(session.getId());
		byte[] value = SerializationUtils.serialize(session);
		this.redisManager.set(key, value, redisManager.getExpire());
	}

	/**
	 * 拼接redis key
	 * 
	 * @param sessionId
	 * @return
	 */
	private byte[] getByteKey(Serializable sessionId) {
		String preKey = this.keyPrefix + sessionId;
		return preKey.getBytes();
	}

}
