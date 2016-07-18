package com.o2o.dao;

import com.o2o.po.Example;

/**
 * @author wulei
 * @date 2016年4月20日
 * @version 1.0
 */
public interface ExampleDao extends BaseDao<Example,java.lang.Long>{
  
	public Integer getCountAll();
	
}
