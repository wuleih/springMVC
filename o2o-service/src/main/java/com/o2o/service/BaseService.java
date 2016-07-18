package com.o2o.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.o2o.ao.QueryInfo;
import com.o2o.ao.WXResultSet;

public interface BaseService<T, ID extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 */
	int save(T entity);
	
	/**
	 * 批量保存实体
	 * 
	 * @param entity
	 * @return
	 */
	int save(Collection<T> entities);
	
	/**
	 * 保存实体，忽略null值
	 * 
	 * @param entity
	 * @return
	 */
	int saveSelective(T entity);
	
	/**
	 * 批量保存实体
	 * 
	 * @param entity
	 * @return
	 */
	int saveSelective(Collection<T> entities);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @return
	 */
	int update(T entity);
	
	/**
	 * 更新实体，忽略null值
	 * 
	 * @param entity
	 * @return
	 */
	int updateSelective(T entity);
	
	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @return
	 */
	int updateByExample(T entity, T example);
	
	/**
	 * 更新实体，忽略null值
	 * 
	 * @param entity
	 * @return
	 */
	int updateByExampleSelective(T entity, T example);

	/**
	 * 如果主键为空则保存，否则则更新实体
	 * 
	 * @param entity
	 * @return
	 */
	int saveOrUpdate(T entity);
	
	/**
	 * 如果主键为空则保存，否则则更新实体，忽略null值
	 * 
	 * @param entity
	 * @return
	 */
	int saveOrUpdateSelective(T entity);

	/**
	 * 按主键删除
	 * 
	 * @param id
	 * @return
	 */
	int delete(ID id);

	/**
	 * 按主键批量删除
	 * 
	 * @param ids
	 * @return
	 */
	int delete(@SuppressWarnings("unchecked") ID... ids);
	
	/**
	 * 按example批量删除
	 * 
	 * @param ids
	 * @return
	 */
	int deleteByExample(T example);

	/**
	 * 按主键查找对象
	 * 
	 * @param id
	 * @return
	 */
	T findById(ID id);

	/**
	 * 查找多个对象
	 * 
	 * @param ids
	 * @return
	 */
	List<T> findById(@SuppressWarnings("unchecked") ID... ids);

	/**
	 * 按实体信息查找，null值忽略，按=进行比较
	 * 
	 * @param entity
	 * @return
	 */
	List<T> findByExample(T entity);

	/**
	 * 按实体分页查找，null值忽略，按=进行比较
	 * 
	 * @param queryInfo
	 * @param entity
	 * @return
	 */
	WXResultSet<T> findPageByExample(QueryInfo queryInfo, T entity);

	/**
	 * 查找个数，null值忽略，按=进行比较
	 * 
	 * @param entity
	 * @return
	 */
	long countByExample(T entity);

	/**
	 * 按实体查找超集，null值忽略，按=进行比较
	 * 
	 * @param entity
	 * @return
	 */
	List<T> findSuperByExample(T entity);

	/**
	 * 按实体查找超级个数，null值忽略，按=进行比较
	 * 
	 * @param entity
	 * @return
	 */
	long countSuperByExample(T entity);

	/**
	 * 按实体分页查找超集，null值忽略，按=进行比较
	 * 
	 * @param queryInfo
	 * @param entity
	 * @return
	 */
	WXResultSet<T> findSuperPageByExample(QueryInfo queryInfo, T entity);
	
	Long generateLocalId(Long companyId);
	
	Long generateId(String ns);
	
	Long generateId();

	Long generateId(Class clz);
}
