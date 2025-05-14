package com.food.service;

import java.util.List;

import com.food.Restaurant;
import com.food.User;
import com.food.dto.RestaurantDto;
import com.food.request.CreateRestaurantRequest;

public interface RestaurantService {
	
	public Restaurant createRestaurant(CreateRestaurantRequest req, User user);
	
	public Restaurant updateRestaurant(long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception;
	
	public void deleteRestaurant(long restaurantId) throws Exception;
	
	public List<Restaurant> getAllRestaurant();
	
	public List<Restaurant> searchRestaurant(String keyword);
	
	public Restaurant findRestaurantById(long id) throws Exception;
	
	public Restaurant getRestaurantByUserId(long userId) throws Exception;
	
	public RestaurantDto addToFavorites(long restaurantId, User user) throws Exception;
	
	public Restaurant updateRestaurantStatus(long id) throws Exception;

}
