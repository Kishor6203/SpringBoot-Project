package com.springsecurity.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springsecurity.entity.Users;

public class MyUserDetails implements UserDetails 
{

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(users.getRole());
		
		return Arrays.asList(authority);
	}

	
	
	@Override
	public String getPassword() 
	{
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return users.getUsername();
	}

	private Users users;
	
	public MyUserDetails(Users users) {
		this.users=users;
	}
}
