package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	@Query("SELECT r FROM Restaurant r WHERE lower(r.name) LIKE lower(concat('%',:query, '%')) "
			+ "OR lower (r.cuisineType) LIKE lower(concat('%', :query, '%'))")
	List<Restaurant> finfBySearchQuery(String query);
	
	Restaurant findByOwnerId(long userId);

}
