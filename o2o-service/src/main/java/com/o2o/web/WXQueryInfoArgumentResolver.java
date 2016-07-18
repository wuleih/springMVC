package com.o2o.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.o2o.ao.QueryInfo;
import com.o2o.util.JsonUtils;

public class WXQueryInfoArgumentResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		// TODO Auto-generated method stub
		if (methodParameter.getParameterType().equals(QueryInfo.class)) {
			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
			String start = request.getParameter("start");
			String limit = request.getParameter("limit");
			String page = request.getParameter("page");
			String modifyTime = request.getParameter("modifyTime");
			String iDisplayStart = request.getParameter("iDisplayStart");
			String iDisplayLength = request.getParameter("iDisplayLength");
			String queryJson = request.getParameter("queryJson");

			Integer i_start = null;
			Integer i_limit = null;
			Integer i_page = null;
			if (StringUtils.isNotEmpty(start)) {
				i_start = Integer.parseInt(start);
			}
			if (StringUtils.isNotEmpty(limit)) {
				i_limit = Integer.parseInt(limit);
			}
			if (StringUtils.isNotEmpty(page)) {
				i_page = Integer.parseInt(page);
			}
			if (StringUtils.isNotEmpty(iDisplayStart)) {
				i_start = Integer.parseInt(iDisplayStart);
			}
			if (StringUtils.isNotEmpty(iDisplayLength)) {
				i_limit = Integer.parseInt(iDisplayLength);
			}
			request.setAttribute("start", start);
			request.setAttribute("limit", limit);
			request.setAttribute("page", page);
			QueryInfo queryInfo = new QueryInfo(i_start, i_limit, i_page, modifyTime);
			queryInfo.setLimit(i_limit);
			if (StringUtils.isNotBlank(queryJson)) {
				queryInfo = JsonUtils.toObject(queryJson, QueryInfo.class);
			}
			return queryInfo;
		}
		return UNRESOLVED;
	}

}
