package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController 
{
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to Home chicha";
	}
	
	@GetMapping("/users23")
	public String users()
	{
		return "Welcome to Users Mamu";
	}
}
