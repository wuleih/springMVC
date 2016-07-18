package com.o2o.dto;

import java.io.Serializable;
import java.util.Date;

import com.o2o.util.DateConvertUtils;


public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 4048680789717695775L;
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
			
	/** ID */
	private Long id;

	/** 创建日期 */
	private Date createTime;
	private Date createTimeBegin;
	private Date createTimeEnd;

	/** 修改日期 */
	private Date modifyTime;
	private Date modifyTimeBegin;
	private Date modifyTimeEnd;
	
	/** 创建人员工编号 */
	private Long creatorId;
	
	/** 修改人员工编号 */
	private Long modifierId;
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public String getCreateTimeString() {
		return DateConvertUtils.format(getCreateTime(), DATE_TIME_FORMAT);
	}
	
	public void setCreateTimeString(String value) {
		setCreateTime(DateConvertUtils.parse(value, DATE_TIME_FORMAT));
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}
	
	public String getModifyTimeString() {
		return DateConvertUtils.format(getModifyTime(), DATE_TIME_FORMAT);
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public void setModifyTimeString(String value) {
		setModifyTime(DateConvertUtils.parse(value, DATE_TIME_FORMAT));
	}
		
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	
	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Date getModifyTimeBegin() {
		return modifyTimeBegin;
	}

	public void setModifyTimeBegin(Date modifyTimeBegin) {
		this.modifyTimeBegin = modifyTimeBegin;
	}

	public Date getModifyTimeEnd() {
		return modifyTimeEnd;
	}

	public void setModifyTimeEnd(Date modifyTimeEnd) {
		this.modifyTimeEnd = modifyTimeEnd;
	}

	/**
	 * 重写equals方法
	 * 
	 * @param obj
	 *            对象
	 * @return 是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return getId() != null ? getId().equals(other.getId()) : false;
	}

	/**
	 * 重写hashCode方法
	 * 
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}
}
