package com.food.service;

import java.util.List;

import com.food.Category;
import com.food.Food;
import com.food.Restaurant;
import com.food.request.CreateFoodRequest;

public interface FoodService {
	
	public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
	
	void deleteFood(long foodId) throws Exception;
	
	public List<Food> getRestaurantsFood(long restaurantId,
			                            boolean isVegitarain,
			                            boolean isNonveg,
			                            boolean isSeasonal,
			                            String foodCategory
			                    
			);
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(long foodId) throws Exception;
	
	public Food updateAvailabilityStatus(long foodId) throws Exception;
	
	

}
