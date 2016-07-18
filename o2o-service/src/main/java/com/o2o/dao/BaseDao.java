package com.o2o.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.o2o.ao.QueryInfo;
import com.o2o.ao.WXResultSet;

/**
 * 设置Dao的原因在于Mapper进行复杂的扩展比较麻烦，同时不希望Example出现在service层
 * @author wulei
 * @param <T>
 * @param <ID>
 * @date 2016年4月20日
 * @version 1.0
 */
public interface BaseDao<T, ID extends Serializable> {
	/***
	 * 生成当前类的本地ID值
	 * 
	 * @return
	 */
	public Long generateLocalId(Long companyId);

	/***
	 * 生成当前类的ID值
	 * 
	 * @return
	 */
	public Long generateId();

	/***
	 * 生成ID值
	 * 
	 * @return
	 */
	public Long generateId(String ns);

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
	 * 保存实体,null值忽略
	 * 
	 * @param entity
	 * @return
	 */
	int saveSelective(T entity);

	/**
	 * 批量保存实体,null值忽略
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
	int delete(ID[] ids);

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
	List<T> findById(ID[] ids);

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

	/**
	 * 生成clz的ID值
	 * 
	 * @param clz
	 * @return
	 */
	Long generateId(Class<T> clz);
	
	public static final String ORDER_BY_CLAUSE = "orderByClause";
}
