package com.o2o.ao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

import com.o2o.util.JsonUtils;


public class QueryInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7042152578528975947L;
	private Integer start = 0;
	private Integer end = 0;
	private Integer page = 0;
	private String modifyTime;
	private Integer limit = 0;
	//上拉刷新时，上次查询的头数据编号
	private String startId = null;
	//下拉刷新时，上次查询的尾数据编号
	private String endId = null;
	/** 本次查询对应的排序key */
	private String sortKey;
	/** 排序参数列表 */
	private List<SortField> orderClauses  = new ArrayList<SortField>();
	/** 用户编号 */
	private Long userId;
	
	public QueryInfo() {
	}
	
	public QueryInfo(Integer limit){
		Assert.notNull(limit);
		this.limit=limit;
	}
		
	public QueryInfo(Integer start,Integer end){
		Assert.notNull(start);
		Assert.notNull(end);
		this.start=start;
		this.end=end;
		this.limit = end - start;
	}
	
	public QueryInfo(Integer start,Integer end,String modifyTime){
		Assert.notNull(start);
		Assert.notNull(end);
		this.start=start;
		this.end=end;
		this.limit = end - start;
		this.modifyTime = modifyTime;
	}
	
	public QueryInfo(Integer start,Integer end,Integer page,String modifyTime){
		this.start=start;
		this.end=end;
		this.page=page;
		this.modifyTime = modifyTime;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public String getStartId() {
		return startId;
	}

	public void setStartId(String startId) {
		this.startId = startId;
	}

	public String getEndId() {
		return endId;
	}

	public void setEndId(String endId) {
		this.endId = endId;
	}

	public List<SortField> getOrderClauses() {
		return orderClauses;
	}
	
	public void addOrderClause(SortField sortField){
		if(orderClauses == null) orderClauses = new ArrayList<SortField>();
		orderClauses.add(sortField);
	}

	public void setOrderClauses(List<SortField> orderClauses) {
		this.orderClauses = orderClauses;
	}

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void assembleParameter(MultiValueMap mvMap) {
		Assert.notNull(mvMap);
		mvMap.add("start", getStart());
		mvMap.add("limit", getLimit());
		
		mvMap.add("queryJson", JsonUtils.toJson(this));
	}
}
