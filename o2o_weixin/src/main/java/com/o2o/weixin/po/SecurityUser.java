package com.o2o.weixin.po;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User{	
	public SecurityUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -6423349660894263533L;
	//尽量少放自定义信息，避免占用资源
	private Long id;	
	private String phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public static SecurityUser sessionUserDetails() {
		 if(SecurityContextHolder.getContext()==null
				   ||SecurityContextHolder.getContext().getAuthentication()==null) return null;
		Object obj =  SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		if(obj == null || !(obj instanceof SecurityUser)){
			return null;
		}
		SecurityUser securityUser = (SecurityUser) obj;
		return securityUser;
	}
}
