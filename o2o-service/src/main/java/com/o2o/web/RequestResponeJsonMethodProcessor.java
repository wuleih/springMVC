package com.o2o.web;

import java.io.BufferedReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.annotation.RequestJson;
import com.o2o.annotation.ResponseJson;

public class RequestResponeJsonMethodProcessor extends  AbstractMessageConverterMethodProcessor {
	
	protected final Log logger = LogFactory.getLog(getClass());
		
	private JsonNode rootJsonNode = null;
	/** ObjectMapper */
	private static ObjectMapper mapper = new ObjectMapper();
		
	protected RequestResponeJsonMethodProcessor(
			List<HttpMessageConverter<?>> messageConverters) {
		super(messageConverters);
		// TODO Auto-generated constructor stub
	}
	
	@Override	
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestJson.class);
	}
	
	@Override
	public boolean supportsReturnType(MethodParameter returnType) {		
		return returnType.getMethodAnnotation(ResponseJson.class) != null;
	}
		
	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        // content-type不是json的不处理
		logger.debug("请求方式："+request.getContentType()); 
        if (!request.getContentType().contains("application/json")) {        	       	
            throw new Exception("未按json格式提交");
        }

        // 把reqeust的body读取到StringBuilder           	
		BufferedReader reader = request.getReader();// 每次请求只能读一次
		StringBuilder sb = new StringBuilder();

		char[] buf = new char[1024];
		int rd;
		while ((rd = reader.read(buf)) != -1) {
			sb.append(buf, 0, rd);
		}
					
		if (!StringUtils.isEmpty(sb.toString())) {
			rootJsonNode = mapper.readTree(sb.toString());
		}    
		
		Class<?> parameterType = parameter.getParameterType();		
		Type type = parameter.getGenericParameterType();
    	Class<?> componentType = Object.class;
    	if(type instanceof ParameterizedType) {
            componentType = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
        }
        
        if(parameter.getParameterType().isArray()) {
            componentType = parameter.getParameterType().getComponentType();
        }
        
        logger.debug("生成类："+componentType.getName());
				        
        String argName = parameter.getParameterName();
                       
        //获取注解信息
        RequestJson annotation = parameter.getParameterAnnotation(RequestJson.class);
        String ann_value  = annotation.value();        
        //json转换为对应的类型
        
        JsonNode jn = null;
        String nodeName = "";
        if(StringUtils.isEmpty(ann_value)){
        	nodeName = argName;//默认
        }else{
        	nodeName = ann_value;
        }
        
        jn = rootJsonNode.get(nodeName);
                       
        if(jn==null) return null;
        
        if(Collection.class.isAssignableFrom(parameterType)){
        	JavaType javaType = null;
        	javaType = mapper.getTypeFactory().constructParametricType(parameterType, componentType);
        	 return mapper.readValue(jn.toString(), javaType);
        }else{
        	return mapper.readValue(jn.toString(), parameterType);
        }               
	}
		
	@SuppressWarnings("unused")
	@Override
	public void handleReturnValue(Object returnValue,
			MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		// TODO Auto-generated method stub
		mavContainer.setRequestHandled(true);
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		
		if (returnValue != null) {
			//获取注解信息
			ResponseJson annotation = returnType.getMethodAnnotation(ResponseJson.class);
		    writeWithMessageConverters(returnValue, returnType, webRequest);
		}
	}
}
