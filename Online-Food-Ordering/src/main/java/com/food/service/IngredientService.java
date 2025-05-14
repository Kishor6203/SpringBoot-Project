package com.food.service;

import java.util.List;

import com.food.IngredientCategory;
import com.food.IngredientsItem;

public interface IngredientService {
	
	public IngredientCategory createIngredientCategory(String name, long restaurantId) throws Exception;
	
	public IngredientCategory findIngredientCategoryById(long id) throws Exception;
	
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(long id) throws Exception;
	
	public IngredientsItem createIngredientItem(long restaurantId,String ingredientName, long categoryId) throws Exception;
	
	public List<IngredientsItem> findRestaurantsIngredients(long restaurantId);
	
	public IngredientsItem updateStock(long id) throws Exception;

}
