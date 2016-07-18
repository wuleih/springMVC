package com.o2o.vo.wx;

import java.io.Serializable;
import java.util.Date;

public class WxJsapiTicket implements Serializable {
	private String errcode;
	private String errmsg;
	private String ticket;
	private Integer expires_in;

	public static final String OBJECT_KEY = "wx_jsapi_ticket";
	/** 应用ID */
	private String appId;
	/** 生效时间 */
	private Date effectiveTime;
	/** 失效时间 */
	private Date expireTime;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}	
}
