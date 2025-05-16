package com.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository repository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public Users saveUser(Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		return repository.save(users);
	}

	public List<Users> getAllUsers() {
		return repository.findAll();
	}

}
