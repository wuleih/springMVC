package com.o2o.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.model.Token;
import com.o2o.dao.WxTokenStorager;

@Repository
public class WxTokenStoragerImpl implements WxTokenStorager {
	/*@Autowired*/ 
	protected RedisTemplate<String,Token> redisTemplate;
	private static String WX_TOKEN_STORAGER = "WX_TOKEN_STORAGER";
	private static final Logger logger = Logger.getLogger(WxTokenStoragerImpl.class);
	
	@Override
	public Token lookup(String cacheKey) throws WeixinException {
		// TODO Auto-generated method stub
		logger.debug("token-cache-key:"+cacheKey);
		Token result = (Token) redisTemplate.opsForHash().get(WX_TOKEN_STORAGER, cacheKey);
		if(result == null) return null;
		
		if(result.getExpiresIn()>0
				&& System.currentTimeMillis() > (result.getExpiresIn()*1000 + result.getTime() - 5 * 60 * 1000)){//验证有时间限制的token数据，避免时间误差，提前5分钟作废
			logger.debug("过期缓存"+cacheKey+":"+result);
			return null;
		}
        return result;  
	}

	@Override
	public void caching(String cacheKey, Token t) throws WeixinException {
		// TODO Auto-generated method stub
		logger.debug("缓存"+cacheKey+":"+t);
		redisTemplate.opsForHash().put(WX_TOKEN_STORAGER, cacheKey, t);
	}

}
