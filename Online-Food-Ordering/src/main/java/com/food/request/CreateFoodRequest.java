package com.food.request;

import java.util.List;

import com.food.Category;
import com.food.IngredientsItem;

public class CreateFoodRequest {
	
	private String name;
	private String description;
	private long price;
	private Category category;
	private List<String> images;
	
	private long restaurantId;
	private boolean Vegetarian;
	private boolean seasonal;
	private List<IngredientsItem> ingredients;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public boolean isVegetarian() {
		return Vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		Vegetarian = vegetarian;
	}
	public boolean isSeasonal() {
		return seasonal;
	}
	public void setSeasonal(boolean seasonal) {
		this.seasonal = seasonal;
	}
	public List<IngredientsItem> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<IngredientsItem> ingredients) {
		this.ingredients = ingredients;
	}
	@Override
	public String toString() {
		return "CreateFoodRequest [name=" + name + ", description=" + description + ", price=" + price + ", category="
				+ category + ", images=" + images + ", restaurantId=" + restaurantId + ", Vegetarian=" + Vegetarian
				+ ", seasonal=" + seasonal + ", ingredients=" + ingredients + "]";
	}
	
	

}
