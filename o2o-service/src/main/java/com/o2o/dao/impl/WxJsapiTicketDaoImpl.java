package com.o2o.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.o2o.dao.AbstractBaseRedisDao;
import com.o2o.dao.WxJsapiTicketDao;
import com.o2o.vo.wx.WxJsapiTicket;

@Repository("wxJsapiTicketDao")
public class WxJsapiTicketDaoImpl extends AbstractBaseRedisDao<WxJsapiTicket, String> implements WxJsapiTicketDao {

	public boolean add(final WxJsapiTicket entity) {
		redisTemplate.opsForHash().put(WxJsapiTicket.OBJECT_KEY, entity.getAppId(), entity);		
        return false; 	
	}

	public boolean add(List<WxJsapiTicket> list) {
		// TODO Auto-generated method stub
		return false;
	}

	public void delete(String key) {
		// TODO Auto-generated method stub
		redisTemplate.opsForHash().delete(WxJsapiTicket.OBJECT_KEY, key);
	}

	public void delete(List<String> keys) {
		// TODO Auto-generated method stub

	}

	public boolean update(WxJsapiTicket entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public WxJsapiTicket get(String keyId) {
		// TODO Auto-generated method stub
		WxJsapiTicket result = (WxJsapiTicket) redisTemplate.opsForHash().get(WxJsapiTicket.OBJECT_KEY, keyId);
        return result;  
	}
}
