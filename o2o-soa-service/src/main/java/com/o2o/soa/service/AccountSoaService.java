package com.o2o.soa.service;

import com.o2o.ao.Message;
import com.o2o.dto.AccountDto;

public interface AccountSoaService {
	
	AccountDto findSUByPhone(String phone);
	Message saveToRedis(AccountDto accountDto);

}
