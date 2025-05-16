package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.Users;
import com.springsecurity.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public Users saveUsers(@RequestBody Users users)
	{
		return usersService.saveUser(users);
	}
	
	@GetMapping
	public List<Users> getAllUsers()
	{
		return usersService.getAllUsers();
	}
}
