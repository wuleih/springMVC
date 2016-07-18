package com.o2o.ao;

import java.io.Serializable;

public class SystemInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1052753298545749608L;
	private String mobileDomain;
	private String imageDomain;
	
	private String weiXinAppId;
	private String weiXinEncodingAesKey;	
	private String weiXinCookieEntry;
	private String weiXinCookieRedirectUri;
	private String weiXinCookieAppid;
	/** 是否允许绑定的cookie名称，允许则弹出对话框 */
	private String weiXinCookieEnableBind;
		
	public String getMobileDomain() {
		return mobileDomain;
	}

	public void setMobileDomain(String mobileDomain) {
		this.mobileDomain = mobileDomain;
	}

	public String getImageDomain() {
		return imageDomain;
	}

	public void setImageDomain(String imageDomain) {
		this.imageDomain = imageDomain;
	}

	public String getWeiXinAppId() {
		return weiXinAppId;
	}

	public void setWeiXinAppId(String weiXinAppId) {
		this.weiXinAppId = weiXinAppId;
	}

	public String getWeiXinEncodingAesKey() {
		return weiXinEncodingAesKey;
	}

	public void setWeiXinEncodingAesKey(String weiXinEncodingAesKey) {
		this.weiXinEncodingAesKey = weiXinEncodingAesKey;
	}


	public String getWeiXinCookieEntry() {
		return weiXinCookieEntry;
	}

	public void setWeiXinCookieEntry(String weiXinCookieEntry) {
		this.weiXinCookieEntry = weiXinCookieEntry;
	}

	public String getWeiXinCookieRedirectUri() {
		return weiXinCookieRedirectUri;
	}

	public void setWeiXinCookieRedirectUri(String weiXinCookieRedirectUri) {
		this.weiXinCookieRedirectUri = weiXinCookieRedirectUri;
	}

	public String getWeiXinCookieAppid() {
		return weiXinCookieAppid;
	}

	public void setWeiXinCookieAppid(String weiXinCookieAppid) {
		this.weiXinCookieAppid = weiXinCookieAppid;
	}

	public String getWeiXinCookieEnableBind() {
		return weiXinCookieEnableBind;
	}

	public void setWeiXinCookieEnableBind(String weiXinCookieEnableBind) {
		this.weiXinCookieEnableBind = weiXinCookieEnableBind;
	}

}
