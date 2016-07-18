package com.o2o.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.o2o.dao.ExampleDao;
import com.o2o.po.Example;

/**
 * @author wulei
 * @date 2016年4月20日
 * @version 1.0
 */
@Repository("exampleDaoImpl")
public class ExampleDaoImpl extends BaseDaoImpl<Example,java.lang.Long> implements ExampleDao{
    
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public String getMapperNamespace() {
		return Example.class.getName() + "Mapper";
	}

	@Override
	public Integer getCountAll() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getMapperNamespace() + ".count");
	}

}
