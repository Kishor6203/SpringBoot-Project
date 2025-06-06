package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.IngredientsItem;

public interface IngredientItemRepository extends JpaRepository<IngredientsItem, Long> {
	
	List<IngredientsItem> findByRestaurantId(long id);

}
