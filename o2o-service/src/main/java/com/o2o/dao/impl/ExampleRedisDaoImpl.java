package com.o2o.dao.impl;

import java.util.List;

import com.o2o.dao.AbstractBaseRedisDao;
import com.o2o.dao.ExampleRedisDao;
import com.o2o.po.Example;
import com.o2o.util.JsonUtils;

/**
 * @author wulei
 * @date 2016年5月9日
 * @version 1.0
 */
public class ExampleRedisDaoImpl extends AbstractBaseRedisDao<Example, String> implements ExampleRedisDao{

	@Override
	public boolean add(Example entity) {
		// TODO Auto-generated method stub
		redisTemplate.opsForHash().put(JsonUtils.toJson(Example.class), entity.getId(), entity);
		return false;
	}

	@Override
	public boolean add(List<Example> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		redisTemplate.opsForHash().delete(JsonUtils.toJson(Example.class), key);
	}

	@Override
	public void delete(List<String> keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Example entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Example get(String keyId) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
