package com.food.request;

import lombok.Data;

@Data
public class IngredientRequest {
	
	private String name;
	
	private long categoryId;
	
	private long restaurantId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "IngredientRequest [name=" + name + ", categoryId=" + categoryId + ", restaurantId=" + restaurantId
				+ "]";
	}
	
	

}
