package com.o2o.vo.wx;

import java.io.Serializable;
import java.util.Date;

public class WxAccessToken implements Serializable {
	public static final String OBJECT_KEY = "wx_access_token";
	/** 应用ID */
	private String appId;
	/** 获取到的凭证 */
	private String access_token;
	/** 凭证有效时间，单位：秒 */
	private Integer expires_in;
	/** 生效时间 */
	private Date effectiveTime;
	/** 失效时间 */
	private Date expireTime;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public Date getEffectiveTime() {
		return effectiveTime;
	}
	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}		
}
