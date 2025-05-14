package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	public List<Category> findByRestaurantId(long id);

}
