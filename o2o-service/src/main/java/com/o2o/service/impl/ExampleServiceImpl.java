package com.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.o2o.dao.ExampleDao;
import com.o2o.service.ExampleService;

@Service("exampleServiceImpl")
public class ExampleServiceImpl implements ExampleService{
	
	@Autowired
	private ExampleDao exampleDao;

	@Override
	public String getStringExample() {
		// TODO Auto-generated method stub
		Integer num = exampleDao.getCountAll();
		if(num < 1){
			return "error";
		}
		return "example";
	}

}
