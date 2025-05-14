package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}

