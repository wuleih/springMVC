package com.o2o.soa.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.o2o.service.ExampleService;
import com.o2o.soa.service.ExampleSoaService;
import com.o2o.util.MultipleDataSource;

public class ExampleSoaServiceImpl implements ExampleSoaService{
	@Autowired
    private ExampleService exampleService;
	@Override
	public String getExampleString() {
		// TODO Auto-generated method stub
		//这一步仅仅是设置ThreadLocal中储存的要获取哪个数据库实例的key  ThreadLocal起缓存作用
		//MultipleDataSource.setCustomerType(MultipleDataSource.DATA_SOURCE_WRITE);
		return exampleService.getStringExample();
	}
}
