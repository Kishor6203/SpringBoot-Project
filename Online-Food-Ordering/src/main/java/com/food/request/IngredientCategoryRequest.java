package com.food.request;

import lombok.Data;

@Data
public class IngredientCategoryRequest {
	
	private String name;
	
	private long restaurantId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "IngredientCategoryRequest [name=" + name + ", restaurantId=" + restaurantId + "]";
	}
	
	

}
