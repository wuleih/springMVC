package com.o2o.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;

import com.o2o.dao.MongoDBBaseDao;

/**
 * @author wulei
 * @param <T>
 * @param <ID>
 * @date 2016年5月9日
 * @version 1.0
 */
public class AbstractMongoDBBaseDaoImpl<T extends Serializable, ID extends Serializable> implements MongoDBBaseDao<T, ID>{
    
	@Autowired 
	protected MongoTemplate mongoTemplate;
	
	@Override
	public boolean add(T entity) {
		// TODO Auto-generated method stub
		mongoTemplate.save(entity);
		return false;
	}

	@Override
	public boolean add(List<T> list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(ID key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(List<ID> keys) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(keys);
	}

	@Override
	public boolean update(T entity) {
		// TODO Auto-generated method stub
		Update up = new Update();
		return false;
	}

	@Override
	public T get(ID keyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
