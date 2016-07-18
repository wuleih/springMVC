package com.o2o.soa.service;

import com.o2o.vo.wx.WxJsapiSignature;
import com.o2o.vo.wx.WxuAccessToken;

public interface WxAuthoritySoaService {
	/**
	 * 获取全局的访问令牌
	 * @return
	 */
	String findAccessToken();
	
	/**
	 * 刷新全局令牌
	 * @return
	 */
	String refreshAccessToken();
	
	/**
	 * oauth2协议下，根据code获取用户信息的访问令牌
	 * @param code
	 * @return
	 */
	WxuAccessToken findWxuAccessToken(String code, String state);
	
	/**
	 * 获取其访问令牌
	 * @param wxOpenId
	 * @return
	 */
	String findWxuAccessToken(String wxOpenId);
	
	/**
	 * 刷新其访问令牌
	 * @param wxOpenId
	 * @return
	 */
	String refreshWxuAccessToken(String wxOpenId);
	
	/**
	 * 获取js的访问令牌
	 * @return
	 */
	String findWxJsapiTicket();
	
	/**
	 * js的签名
	 * @param url
	 * @return
	 */
	WxJsapiSignature getJsapiSignature(String url);
	
	/**
	 * 将url包装成带验证参数的url
	 * @param redirectUrl
	 * @return
	 */
	String wxAuth2UrlFormat(String redirectUrl);
}
