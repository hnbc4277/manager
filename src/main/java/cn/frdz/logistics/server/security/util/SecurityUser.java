package cn.frdz.logistics.server.security.util;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.frdz.logistics.server.business.entity.sys.User;


public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 4219266822774725214L;

	private Collection<GrantedAuthority> authorities;
	
	private User user;
	
	public SecurityUser(User user,Object object) {
		if (user != null) {
			this.user = user;
			authorities = new ArrayList<>();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER,ADMIN_USER");
			authorities.add(authority);
		}
	}
	
	@Override
	public String getUsername() {
		return this.user.getUsername();
	}
	
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
