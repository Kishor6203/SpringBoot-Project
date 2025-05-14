package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	public Cart findByCustomerId(long userId);
}

