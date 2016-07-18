package com.o2o.soa.impl;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.chanjar.weixin.mp.api.WxMpService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import weixin.popular.api.SnsAPI;
import weixin.popular.api.TicketAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.ticket.Ticket;
import weixin.popular.bean.token.Token;
import weixin.popular.support.TokenManager;

import com.foxinmy.weixin4j.http.factory.HttpClientFactory;
import com.foxinmy.weixin4j.http.factory.HttpComponent4Factory;
import com.foxinmy.weixin4j.http.factory.Netty4HttpClientFactory;
import com.o2o.ao.SystemInfo;
import com.o2o.dao.WxAccessTokenDao;
import com.o2o.dao.WxJsapiTicketDao;
import com.o2o.dao.WxuAccessTokenDao;
import com.o2o.service.base.WxAbstractSoaService;
import com.o2o.soa.service.WxAuthoritySoaService;
import com.o2o.util.DateConvertUtils;
import com.o2o.util.O2OStringUtils;
import com.o2o.util.O2OStringUtils;
import com.o2o.vo.wx.WxAccessToken;
import com.o2o.vo.wx.WxJsapiSignature;
import com.o2o.vo.wx.WxJsapiTicket;
import com.o2o.vo.wx.WxuAccessToken;

public class WxAuthoritySoaServiceImpl extends WxAbstractSoaService implements WxAuthoritySoaService {
	@Autowired
	private WxAccessTokenDao wxAccessTokenDao;	
	@Autowired
	private WxuAccessTokenDao wxuAccessTokenDao;	
	@Autowired
	private WxJsapiTicketDao wxJsapiTicketDao;
	@Autowired
	private SystemInfo systemInfo;
		
	@Override
	public String findAccessToken() {
		// TODO Auto-generated method stub
		WxAccessToken accessToken = wxAccessTokenDao.get(appId);
		return accessToken.getAccess_token();		
	}

	@Override
	public String refreshAccessToken() {
		// TODO Auto-generated method stub				
		try {
			WxAccessToken accessToken = wxAccessTokenDao.get(appId);
			if(accessToken==null
					||(new Date().getTime()-accessToken.getExpireTime().getTime())>-60*1000){
				Token token = TokenAPI.token(appId, appSecret);
				if(StringUtils.isEmpty(token.getAccess_token())||token.getExpires_in()==0){
					return null;
				} 
				accessToken = new WxAccessToken();
				BeanUtils.copyProperties(token, accessToken);
				accessToken.setAppId(appId);
				accessToken.setEffectiveTime(new Date());
				accessToken.setExpireTime(new Date(accessToken.getEffectiveTime().getTime()+accessToken.getExpires_in()*1000));
				wxAccessTokenDao.add(accessToken);
			}
			
			return accessToken.getAccess_token();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			wxAccessTokenDao.delete(appId);
		}
		return null;
	}

	public WxuAccessToken findWxuAccessToken(String code, String state) {
		// TODO Auto-generated method stub		
		try {			
			SnsToken snsToken = SnsAPI.oauth2AccessToken(appId, appSecret, code);
			if(StringUtils.isEmpty(snsToken.getAccess_token())||snsToken.getExpires_in()==null){
				return null;
			} 
			
			WxuAccessToken accessToken = new WxuAccessToken();
			BeanUtils.copyProperties(snsToken, accessToken);
			accessToken.setAppId(appId);
			accessToken.setEffectiveTime(new Date());			
			accessToken.setExpireTime(new Date(accessToken.getEffectiveTime().getTime() + accessToken.getExpires_in() * 1000));

			wxuAccessTokenDao.add(accessToken);
						
			return accessToken;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public String findWxuAccessToken(String wxOpenId) {
		// TODO Auto-generated method stub
		WxuAccessToken accessToken = wxuAccessTokenDao.get(wxOpenId);
		if(accessToken!=null
				&&(new Date().getTime()-accessToken.getExpireTime().getTime())<0){			
			return accessToken.getAccess_token();
		}
		
		return null;
	}
    
	//企业号令牌
	public String refreshWxuAccessToken(String  wxOpenId) {
		// TODO Auto-generated method stub
		WxuAccessToken accessToken = wxuAccessTokenDao.get(wxOpenId);
		if(accessToken==null) {
			return null;
			}
		
		String refreshToken = accessToken.getRefresh_token();				
		try {						
			accessToken = new WxuAccessToken();
			SnsToken snsToken = SnsAPI.oauth2RefreshToken(appId, refreshToken);
			if(StringUtils.isEmpty(snsToken.getAccess_token())||snsToken.getExpires_in()==null) return null;
			
			BeanUtils.copyProperties(snsToken, accessToken);
			accessToken.setAppId(appId);			
			accessToken.setEffectiveTime(new Date());
			accessToken.setExpireTime(new Date(accessToken.getEffectiveTime().getTime()+accessToken.getExpires_in()*1000));
			
			wxuAccessTokenDao.add(accessToken);
			
			return accessToken.getAccess_token();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findWxJsapiTicket() {
		WxJsapiTicket wxJsapiTicket = wxJsapiTicketDao.get(appId);
		if(wxJsapiTicket!=null&&wxJsapiTicket.getExpireTime() != null &&(new Date().getTime()-wxJsapiTicket.getExpireTime().getTime())<0){
			return wxJsapiTicket.getTicket();
		}
				
		String accessToken = findAccessToken();
		Ticket ticket = TicketAPI.ticketGetticket(accessToken);
		if(!ticket.getErrcode().equals("0")){
			return null;
		}
		
		wxJsapiTicket = new WxJsapiTicket();
		wxJsapiTicket.setAppId(appId);
		wxJsapiTicket.setEffectiveTime(new Date());
		wxJsapiTicket.setErrcode(ticket.getErrcode());
		wxJsapiTicket.setErrmsg(ticket.getErrmsg());
		wxJsapiTicket.setExpires_in(ticket.getExpires_in());
		wxJsapiTicket.setExpireTime(new Date(System.currentTimeMillis()+ticket.getExpires_in()*1000));
		wxJsapiTicket.setTicket(ticket.getTicket());
		
		this.wxJsapiTicketDao.add(wxJsapiTicket);
		
		return ticket.getTicket();
	}

	@Override
	public WxJsapiSignature getJsapiSignature(String url) {
		// TODO Auto-generated method stub			
		String jsapiTicket = findWxJsapiTicket();
		if(StringUtils.isEmpty(jsapiTicket)) {
			return null;
			}
		String str = O2OStringUtils.getRandomString(16);		
		String timestamp = DateConvertUtils.format(new Date(), "yyyyMMddHHmm");
		// 线程不安全 效率高
		StringBuilder sb = new StringBuilder();
		sb.append("jsapi_ticket=");
		sb.append(jsapiTicket);
		sb.append("&noncestr=");
		sb.append(str);
		sb.append("&timestamp=");
		sb.append(timestamp);
		sb.append("&url=");
		sb.append(url);
        
		WxJsapiSignature wxJsapiSignature = new WxJsapiSignature();
		wxJsapiSignature.setAppId(appId);
		wxJsapiSignature.setNonceStr(str);
		wxJsapiSignature.setTimestamp(timestamp);
				
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(sb.toString().getBytes());
			tmpStr = O2OStringUtils.byteToStr(digest);
			logger.debug("字节转换成十六进制字符串:"+tmpStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (tmpStr != null) {
			wxJsapiSignature.setSignature(tmpStr);			
			return wxJsapiSignature;
		}
		
		return null;
	}

	@Override
	public String wxAuth2UrlFormat(String redirectUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	static {
		if(HttpClientFactory.getDefaultFactory() instanceof Netty4HttpClientFactory){
			HttpClientFactory.setDefaultFactory(new HttpComponent4Factory());
		}
	}
}
