package com.o2o.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.o2o.ao.QueryInfo;
import com.o2o.ao.WXResultSet;
import com.o2o.ao.SystemInfo;
import com.o2o.dao.BaseDao;
import com.o2o.service.BaseService;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
	@Autowired
	protected SystemInfo systemInfo;
	
	private BaseDao<T, ID> baseDao;

	public void setBaseDao(BaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public int save(T entity) {
		// TODO Auto-generated method stub
		return baseDao.save(entity);
	}
	
	@Override
	public int save(Collection<T> entities) {
		// TODO Auto-generated method stub
		return baseDao.save(entities);
	}
	
	@Override
	public int saveSelective(T entity) {
		// TODO Auto-generated method stub
		return baseDao.saveSelective(entity);
	}
	
	@Override
	public int saveSelective(Collection<T> entities) {
		// TODO Auto-generated method stub
		return baseDao.saveSelective(entities);
	}

	@Override
	public int update(T entity) {
		// TODO Auto-generated method stub
		return baseDao.update(entity);
	}
	
	@Override
	public int updateSelective(T entity) {
		// TODO Auto-generated method stub
		return baseDao.updateSelective(entity);
	}
	
	@Override
	public int updateByExample(T entity, T example) {
		// TODO Auto-generated method stub
		return baseDao.updateByExample(entity, example);
	}
	
	@Override
	public int updateByExampleSelective(T entity, T example) {
		// TODO Auto-generated method stub
		return baseDao.updateByExampleSelective(entity, example);
	}

	@Override
	public int saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		return baseDao.saveOrUpdate(entity);
	}
	
	@Override
	public int saveOrUpdateSelective(T entity) {
		// TODO Auto-generated method stub
		return baseDao.saveOrUpdateSelective(entity);
	}

	@Override
	public int delete(ID id) {
		// TODO Auto-generated method stub
		return baseDao.delete(id);
	}

	@Override
	public int delete(@SuppressWarnings("unchecked") ID... ids) {
		// TODO Auto-generated method stub
		return baseDao.delete(ids);
	}
	
	@Override
	public int deleteByExample(T example) {
		// TODO Auto-generated method stub
		return baseDao.deleteByExample(example);
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return baseDao.findById(id);
	}

	@Override
	public List<T> findById(@SuppressWarnings("unchecked") ID... ids) {
		// TODO Auto-generated method stub
		return baseDao.findById(ids);
	}

	@Override
	public List<T> findByExample(T entity) {
		// TODO Auto-generated method stub
		return baseDao.findByExample(entity);
	}
	

	@Override
	public WXResultSet<T> findPageByExample(QueryInfo queryInfo, T entity) {
		// TODO Auto-generated method stub				
		return baseDao.findPageByExample(queryInfo, entity);
	}
	
	@Override
	public long countByExample(T entity) {
		// TODO Auto-generated method stub
		return baseDao.countByExample(entity);
	}
	
	@Override
	public List<T> findSuperByExample(T entity){
		return baseDao.findSuperByExample(entity);
	}
	
	@Override
	public long countSuperByExample(T entity){
		return baseDao.countSuperByExample(entity);
	}
	
	@Override
	public WXResultSet<T> findSuperPageByExample(QueryInfo queryInfo, T entity){
		return baseDao.findSuperPageByExample(queryInfo, entity);
	}
	
	@Override
	public Long generateLocalId(Long companyId){
		return baseDao.generateLocalId(companyId);
	}
	
	@Override
	public Long generateId(){
		return baseDao.generateId();
	}
	
	@Override
	public Long generateId(String ns){
		return baseDao.generateId(ns);
	}
	
	@Override
	public Long generateId(Class clz){
		return baseDao.generateId(clz);
	}
}
