package com.o2o.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidatorUtils {
	
	public static boolean isMobilePhone(String mobile_phone){
		Pattern p = Pattern.compile("((13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}?[,，]?)|(((0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?[,，]?)?)"); 
		Matcher m = p.matcher(mobile_phone);		 		  
		return m.matches();		
	}
	
	public static boolean isMobile(String mobile){
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$"); 
		Matcher m = p.matcher(mobile);		 		  
		return m.matches();		
	}
	
	public static boolean validate(String password){
		Pattern p = Pattern.compile("^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*\\S)[A-Za-z0-9\\S]{6,}$"); 
		Matcher m = p.matcher(password);		 		  
		return m.matches();		
	}
	
	public static boolean isPhone(String phone){
		Pattern p = Pattern.compile("^((0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?[,]?)+$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	public static boolean isEmail(String email){
		EmailValidator vemail = EmailValidator.getInstance();		
		return vemail.isValid(email);
	}
	
	public static boolean isPassword(String password){
		Pattern p = Pattern.compile("^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*\\S)[A-Za-z0-9\\S]{6,}$"); 
		Matcher m = p.matcher(password);		 		  
		return m.matches();		
	}
}
