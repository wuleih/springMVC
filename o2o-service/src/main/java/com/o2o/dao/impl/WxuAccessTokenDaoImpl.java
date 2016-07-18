package com.o2o.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.o2o.dao.AbstractBaseRedisDao;
import com.o2o.dao.WxuAccessTokenDao;
import com.o2o.vo.wx.WxuAccessToken;

@Repository
public class WxuAccessTokenDaoImpl extends AbstractBaseRedisDao<WxuAccessToken, String> implements WxuAccessTokenDao {
			
	@Override
	public boolean add(final WxuAccessToken entity) {
		// TODO Auto-generated method stub	
		redisTemplate.opsForHash().put(WxuAccessToken.OBJECT_KEY, entity.getOpenid(), entity);
        return false; 		
	}

	@Override
	public boolean add(List<WxuAccessToken> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		redisTemplate.opsForHash().delete(WxuAccessToken.OBJECT_KEY, key);
	}

	@Override
	public void delete(List<String> keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(WxuAccessToken entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WxuAccessToken get(final String key) {
		// TODO Auto-generated method stub
		WxuAccessToken result = (WxuAccessToken) redisTemplate.opsForHash().get(WxuAccessToken.OBJECT_KEY, key);
        return result;  
	}

}
