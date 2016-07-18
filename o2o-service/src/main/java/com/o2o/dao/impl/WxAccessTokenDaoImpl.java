package com.o2o.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.o2o.dao.AbstractBaseRedisDao;
import com.o2o.dao.WxAccessTokenDao;
import com.o2o.vo.wx.WxAccessToken;

@Repository("wxAccessTokenDaoImpl")
public class WxAccessTokenDaoImpl extends AbstractBaseRedisDao<WxAccessToken, String> implements WxAccessTokenDao {
			
	@Override
	public boolean add(final WxAccessToken entity) {
		// TODO Auto-generated method stub		
		redisTemplate.opsForHash().put(WxAccessToken.OBJECT_KEY, entity.getAppId(), entity);		
        return true; 		
	}

	@Override
	public boolean add(List<WxAccessToken> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		redisTemplate.opsForHash().delete(WxAccessToken.OBJECT_KEY, key);
	}

	@Override
	public void delete(List<String> keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(WxAccessToken entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WxAccessToken get(final String key) {
		// TODO Auto-generated method stub
		WxAccessToken result = (WxAccessToken) redisTemplate.opsForHash().get(WxAccessToken.OBJECT_KEY, key);
        return result;  
	}

}
