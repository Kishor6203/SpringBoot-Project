package com.food.service;

import java.util.List;

import com.food.Category;

public interface CategoryService {
	
	public Category createCategory(String name, long userId) throws Exception;
	
	public List<Category> findCategoryByRestaurantId(long id) throws Exception;
	
	public Category findCategoryById(long id) throws Exception;

}
