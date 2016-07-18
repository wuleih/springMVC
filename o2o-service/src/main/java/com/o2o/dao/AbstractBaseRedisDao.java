package com.o2o.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author wulei
 * @param <T>
 * @param <ID>
 * @date 2016年5月9日
 * @version 1.0
 */
public abstract class AbstractBaseRedisDao<T extends Serializable, ID extends Serializable> implements BaseRedisDao<T, ID> {
    @Autowired
	protected RedisTemplate<String,T> redisTemplate;
}
