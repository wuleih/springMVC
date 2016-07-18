package com.o2o.weixin.web;

import java.io.IOException;
import java.io.PrintStream;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WXMappingJacksonHttpMessageConverter extends	MappingJackson2HttpMessageConverter {
	
	public WXMappingJacksonHttpMessageConverter() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.setConfig(objectMapper.getSerializationConfig().withSerializationInclusion(Include.ALWAYS));
	    setObjectMapper(objectMapper);
	}
		
	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String jsonpCallback = null;

	    RequestAttributes reqAttrs = RequestContextHolder.currentRequestAttributes();
	    if(reqAttrs instanceof ServletRequestAttributes){
	        jsonpCallback = ((ServletRequestAttributes)reqAttrs).getRequest().getParameter("jsonpCallback");
	    }

	    if(jsonpCallback != null){
	        new PrintStream(outputMessage.getBody()).print(jsonpCallback + "(");
	    }

	    super.writeInternal(object, outputMessage);

	    if(jsonpCallback != null){
	        new PrintStream(outputMessage.getBody()).println(");");
	    }
	}
}
