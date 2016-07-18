package com.o2o.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author wulei
 * @param <T>
 * @param <ID>
 * @date 2016年5月9日
 * @version 1.0
 */
public interface BaseRedisDao<T extends Serializable, ID extends Serializable> {
	/**
	 * 新增
	 * 
	 * @return
	 */
	boolean add(T entity);

	/**
	 * 批量新增 使用pipeline方式
	 * 
	 * @param list
	 * @return
	 */
	boolean add(List<T> list);

	/**
	 * 删除
	 * 
	 * @param key
	 */
	void delete(ID key);

	/**
	 * 删除多个
	 * 
	 * @param keys
	 */
	void delete(List<ID> keys);

	/**
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	boolean update(T entity);

	/**
	 * 通过key获取
	 * 
	 * @param keyId
	 * @return
	 */
	T get(ID keyId);
}
