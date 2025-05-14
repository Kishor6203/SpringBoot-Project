package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.Food;
import com.food.Restaurant;
import com.food.User;
import com.food.request.CreateFoodRequest;
import com.food.response.MessageResponse;
import com.food.service.FoodService;
import com.food.service.RestaurantService;
import com.food.service.UserService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping()
	public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
		Food food=foodService.createFood(req, req.getCategory(), restaurant);
		return new ResponseEntity<>(food, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> deleteFood(@PathVariable long id,
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		foodService.deleteFood(id);
		
		MessageResponse resp=new MessageResponse();
		resp.setMessage("food deleted successfully");
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable long id,
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		Food food=foodService.updateAvailabilityStatus(id);
		
		return new ResponseEntity<>(food, HttpStatus.CREATED);
	}
	

}
