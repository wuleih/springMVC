package com.o2o.weixin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.o2o.ao.DateEditor;
import com.o2o.ao.SystemInfo;
import com.o2o.soa.service.WxAuthoritySoaService;
import com.o2o.util.SpringUtils;
import com.o2o.util.WebUtils;
import com.o2o.weixin.po.SecurityUser;
import com.sun.star.uno.RuntimeException;

public class BaseController {
	protected Logger logger = Logger.getLogger(this.getClass());		
	public static final String LOG_CONTENT_ATTRIBUTE_NAME = "LOG_CONTENT";
	@Autowired
	protected SystemInfo systemInfo;
	@Autowired
	private WxAuthoritySoaService wxAuthoritySoaService;
	
	/**
	 * 数据绑定
	 * 
	 * @param binder
	 *            WebDataBinder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));		
	    binder.registerCustomEditor(Date.class, new DateEditor());  
	}	
	
	@ModelAttribute
	public void init(ModelMap model, HttpServletRequest request,HttpServletResponse response) {		
		model.put("imageDomain", "图片的IP地址");
		model.put("systemInfo", systemInfo);
		/*//获取不包含参数的请求路径
		StringBuffer  sb = request.getRequestURL();
		sb.append("?"+request.getQueryString());
		try {
			response.sendRedirect("http://10.15.50.245:8080/o2o_weixin/com/o2o/example.do");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//请求分发前验证令牌
		wxAuthoritySoaService.refreshAccessToken();
		model.addAttribute("jsapiSignature", this.wxAuthoritySoaService.getJsapiSignature(WebUtils.getUrl(request)));
	}
	
	public SecurityUser getSessionUserDetails(HttpServletRequest request) {		 
		return SecurityUser.sessionUserDetails();
	}
}
