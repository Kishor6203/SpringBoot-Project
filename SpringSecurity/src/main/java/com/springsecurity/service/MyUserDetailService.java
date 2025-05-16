package com.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.config.MyUserDetails;
import com.springsecurity.entity.Users;
import com.springsecurity.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService 
{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<Users> opt = repository.findByUsername(username);
		if(opt.isPresent())
		{
			return new MyUserDetails(opt.get());
		}
		else
		{
			throw new UsernameNotFoundException("user name not available in database");
		}
	}
	
	
}
