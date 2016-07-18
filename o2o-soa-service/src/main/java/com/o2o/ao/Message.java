package com.o2o.ao;

import java.io.Serializable;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.o2o.util.SpringUtils;


/**
 * 消息
 * 
 */
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1718263655383672019L;

	/**
	 * 类型
	 */
	public enum Type {

		/** 成功 */
		success,

		/** 警告 */
		warn,

		/** 错误 */
		error
	}

	/** 类型 */
	private Type type;

	/** 内容 */
	private String content;

	private Object extra;

	/**
	 * 初始化一个新创建的 Message 对象，使其表示一个空消息。
	 */
	public Message() {

	}
	
	public Message(BindingResult result, Class<?> clz) {
		if(result == null) return;
		if(!result.hasErrors()){
			this.type = Type.success;
		}else{
			this.type = Type.error;
			List<FieldError> errors = result.getFieldErrors();
			StringBuilder sb = new StringBuilder();
			for(FieldError error : errors){				
				String fieldName = SpringUtils.getMessage(clz.getSimpleName()+"."+error.getField(), null);
				sb.append(fieldName + error.getDefaultMessage()+";");
			}
			
			this.content = sb.toString();
		}
	}

	/**
	 * 初始化一个新创建的 Message 对象
	 * 
	 * @param type
	 *            类型
	 * @param content
	 *            内容
	 */
	public Message(Type type, String content) {
		this.type = type;
		if(content!=null&&content.startsWith("{")&&content.endsWith("}")){
			String code = content.substring(1);
			code = code.substring(0, code.length()-1);
			this.content = SpringUtils.getMessage(code);
		}else{
			this.content = content;
		}
	}

	/**
	 * @param type
	 *            类型
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 */
	public Message(Type type, String content, Object... args) {
		this.type = type;
		if(content!=null&&content.startsWith("{")&&content.endsWith("}")){
			String code = content.substring(1);
			code = code.substring(0, code.length()-1);
			this.content = SpringUtils.getMessage(code, args);
		}else{
			this.content = content;
		}
	}

	/**
	 * 返回成功消息
	 * 
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 * @return 成功消息
	 */
	public static Message success(String content, Object... args) {
		return new Message(Type.success, content, args);
	}

	/**
	 * 返回警告消息
	 * 
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 * @return 警告消息
	 */
	public static Message warn(String content, Object... args) {
		return new Message(Type.warn, content, args);
	}

	/**
	 * 返回错误消息
	 * 
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 * @return 错误消息
	 */
	public static Message error(String content, Object... args) {
		return new Message(Type.error, content, args);
	}
	
	public static String enumMessage(Enum obj){
		if(obj == null) return null;
		String code = obj.getClass().getName()+"."+obj.name();
		return SpringUtils.getMessage(code, null);
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	public Type getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * 获取内容
	 * 
	 * @return 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 * 
	 * @param content
	 *            内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}
