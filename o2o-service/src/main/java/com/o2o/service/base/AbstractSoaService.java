package com.o2o.service.base;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.o2o.ao.SystemInfo;

public abstract class AbstractSoaService {
		
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	protected SystemInfo systemInfo;	
}
