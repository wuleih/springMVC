package com.o2o.dto;

import java.io.Serializable;

public class AccountDto extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2096203883595270201L;
	private String phone;
	private String password;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
