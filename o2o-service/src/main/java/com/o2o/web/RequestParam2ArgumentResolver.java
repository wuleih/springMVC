package com.o2o.web;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.o2o.annotation.RequestParam2;

/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings({ "unused", "rawtypes" })
public class RequestParam2ArgumentResolver implements HandlerMethodArgumentResolver {
	
	private final Logger logger = Logger.getLogger(getClass());
			
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return parameter.hasParameterAnnotation(RequestParam2.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub				
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);	
		logger.debug("请求头："+request.getContentType());
		
		String argName = parameter.getParameterName();
		
		//获取注解信息
		RequestParam2 annotation = parameter.getParameterAnnotation(RequestParam2.class);
        String ann_value  = annotation.value();
        
        Boolean required = annotation.required();
                     
        String value = "",paramName="";
        if(StringUtils.isEmpty(ann_value)){
        	paramName = argName;
        }else{
        	paramName = ann_value;
        }
        
        String[] paramValues = webRequest.getParameterValues(paramName);
		Class<?> paramType = parameter.getParameterType();
                
        Type type = parameter.getGenericParameterType();//对象类型
    	Class<?> componentType = parameter.getParameterType();
    	if(type instanceof ParameterizedType) {
            componentType = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
        }        
        if(parameter.getParameterType().isArray()) {
            componentType = parameter.getParameterType().getComponentType();
        }
        
        logger.debug("生成对象类："+componentType.getName());
       		        
        return null;
	}		
	
	private Object generateBaseObject(Class cls,String value){
		if(StringUtils.isEmpty(value)){
			return value;
		}
		if(cls.equals(Integer.class)||cls.equals(int.class)){
			return Integer.valueOf(value);
		}
		if(cls.equals(Long.class)||cls.equals(long.class)){
			return Long.valueOf(value);
		}
		if(cls.equals(Float.class)||cls.equals(float.class)){
			return Float.valueOf(value);
		}
		if(cls.equals(Double.class)||cls.equals(double.class)){
			return Double.valueOf(value);
		}
		if(cls.equals(Boolean.class)||cls.equals(boolean.class)){
			return Boolean.valueOf(value);
		}
		
		return value;		
	}
}
