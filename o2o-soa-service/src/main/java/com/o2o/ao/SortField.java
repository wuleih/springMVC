package com.o2o.ao;

import java.io.Serializable;

public class SortField implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4864048671934629314L;
	/** 顺序 */
	private int index;
	/** 属性名 */
	private String propertyName;
	/** 排序方向 */
	private OrderDirection orderDirection;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public OrderDirection getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(OrderDirection orderDirection) {
		this.orderDirection = orderDirection;
	}
}
