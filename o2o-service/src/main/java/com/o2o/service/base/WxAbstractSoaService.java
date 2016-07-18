package com.o2o.service.base;

import org.springframework.beans.factory.annotation.Value;

public abstract class WxAbstractSoaService extends AbstractSoaService{
	@Value("${micro.msg.appId}")
	protected String appId;	
	@Value("${micro.msg.appSecret}")
	protected String appSecret;
	@Value("${micro.msg.customToken}")
	protected String customToken;
	@Value("${micro.msg.encodingAESKey}")
	protected String encodingAESKey;
}
