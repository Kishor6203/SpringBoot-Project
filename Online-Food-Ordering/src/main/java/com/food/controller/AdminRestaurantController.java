package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.Restaurant;
import com.food.User;
import com.food.request.CreateRestaurantRequest;
import com.food.response.MessageResponse;
import com.food.service.RestaurantService;
import com.food.service.UserService;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/{id}")
	public ResponseEntity<Restaurant> createRestaurant(
			@RequestBody CreateRestaurantRequest req,
			@RequestHeader("Authorization") String jwt
			) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		
		Restaurant restaurant=restaurantService.createRestaurant(req, user);
		return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> updateteRestaurant(
			@RequestBody CreateRestaurantRequest req,
			@RequestHeader("Authorization") String jwt,
			@PathVariable long id
			) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		
		Restaurant restaurant=restaurantService.updateRestaurant(id, req);
		return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> deleteRestaurant(
			@RequestHeader("Authorization") String jwt,
			@PathVariable long id
			) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		
		restaurantService.deleteRestaurant(id);
		
		MessageResponse resp=new MessageResponse();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/status")
	public ResponseEntity<Restaurant> updateRestaurantStatus(
			@RequestHeader("Authorization") String jwt,
			@PathVariable long id
			) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		
		Restaurant restaurant=restaurantService.updateRestaurantStatus(id);
		
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<Restaurant> findRestaurantByUserId(
			@RequestHeader("Authorization") String jwt
			) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		
		Restaurant restaurant=restaurantService.getRestaurantByUserId(user.getId());
		
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}

}
