package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.Category;
import com.food.User;
import com.food.service.CategoryService;
import com.food.service.UserService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/category")
	public ResponseEntity<Category>createCategory(@RequestBody Category category,
			@RequestHeader ("Autorization") String jwt) throws Exception{
		
		User user=userService.findUserByEmail(jwt);
		Category createCategory=categoryService.createCategory(category.getName(), user.getId());
		
		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("/category/restaurant")
	public ResponseEntity<List<Category>>getRestaurantCategory(
			@RequestHeader ("Autorization") String jwt) throws Exception{
		
		User user=userService.findUserByEmail(jwt);
		List<Category> categories=categoryService.findCategoryByRestaurantId(user.getId());
		
		return new ResponseEntity<>(categories, HttpStatus.CREATED);
	}

}
