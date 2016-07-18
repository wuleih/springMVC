package com.o2o.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 为方便书写，取名RequestParam2，请勿3、4、5的后续跟进
 * @author wulei
 * @date 2016年4月22日
 * @version 1.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam2 {
	/**
	 * 对应参数名称
	 * @return
	 */
	String value() default "";
	
	boolean required() default false;	
}
