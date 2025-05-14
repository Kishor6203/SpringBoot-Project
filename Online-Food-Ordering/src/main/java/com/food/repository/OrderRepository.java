package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	public List<Order> findByCustomerId(long userId);
	
	public List<Order> findByRestaurantId(long restaurantId);

}
