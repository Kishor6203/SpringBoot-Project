package com.food.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.Cart;
import com.food.USER_ROLE;
import com.food.User;
import com.food.config.JwtProvider;
import com.food.repository.CartRepository;
import com.food.repository.UserRepository;
import com.food.request.LoginRequest;
import com.food.response.AuthResponse;
import com.food.service.CustomerUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsServices;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse>createUserHandler(@RequestBody User user) throws Exception{

		
		User isEmailExist=userRepository.findByEmail(user.getEmail());
		if(isEmailExist!=null) {
			throw new Exception("Email is already used with another account");
		}
		
		User createdUser=new User();
		createdUser.setEmail(user.getEmail());
		createdUser.setFullName(user.getFullName());
		createdUser.setRole(user.getRole());
		createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser = userRepository.save(createdUser);
		
		Cart cart = new Cart();
		cart.setCustomer(savedUser);
		cartRepository.save(cart);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generationToken(authentication);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("Login success");
		authResponse.setRole(savedUser.getRole());
		
		
		return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest req){
		
		String username=req.getEmail();
		String password=req.getPassword();
		
		Authentication authentication=Authenticate(username, password);
		
		Collection<?extends GrantedAuthority>authority=authentication.getAuthorities();
		String role=authority.isEmpty()?null:authority.iterator().next().getAuthority();
		
		String jwt = jwtProvider.generationToken(authentication);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("Login success");
		authResponse.setRole(USER_ROLE.valueOf(role));
		
		
		return new ResponseEntity<>(authResponse,HttpStatus.OK);
		
	}

	private Authentication Authenticate(String username, String password) {
	    UserDetails userDetails = customerUserDetailsServices.loadUserByUsername(username);

	    if (userDetails == null) {
	        throw new BadCredentialsException("Invalid username........");
	    }

	    if (!passwordEncoder.matches(password, userDetails.getPassword())) {
	        throw new BadCredentialsException("Invalid password........");
	    }

	    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

}
