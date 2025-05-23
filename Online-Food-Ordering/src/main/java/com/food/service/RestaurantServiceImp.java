package com.food.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Address;
import com.food.Restaurant;
import com.food.User;
import com.food.dto.RestaurantDto;
import com.food.repository.AddressRepository;
import com.food.repository.RestaurantRepository;
import com.food.repository.UserRepository;
import com.food.request.CreateRestaurantRequest;

@Service
public class RestaurantServiceImp implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
		
		Address address=addressRepository.save(req.getAddress());
		
		Restaurant restaurant=new Restaurant();
		restaurant.setAddress(address);
		restaurant.setContactinformation(req.getContactInformation());
		restaurant.setCuisineType(req.getCuisineType());
		restaurant.setDescription(req.getDescription());
		restaurant.setImages(req.getImages());
		restaurant.setName(req.getName());
		restaurant.setOpeningHours(req.getOpningHours());
		restaurant.setRegistrationDate(LocalDateTime.now());
		restaurant.setOwner(user);
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception {
		
		Restaurant restaurant=findRestaurantById(restaurantId);
		
		if(restaurant.getCuisineType()!=null) {
			restaurant.setCuisineType(updateRestaurant.getCuisineType());
		}
		if(restaurant.getDescription()!=null) {
			restaurant.setDescription(updateRestaurant.getDescription());
		}
		if(restaurant.getName()!=null) {
			restaurant.setName(updateRestaurant.getName());
		}
		return restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(long restaurantId) throws Exception {
		Restaurant restaurant=findRestaurantById(restaurantId);
		
		restaurantRepository.delete(restaurant);
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> searchRestaurant(String keyword) {
		return restaurantRepository.finfBySearchQuery(keyword);
	}

	@Override
	public Restaurant findRestaurantById(long id) throws Exception {
		Optional<Restaurant> opt=restaurantRepository.findById(id);
		if(opt.isEmpty()) {
			throw new Exception("restaurant not found with id"+id);
		}
		return opt.get();
	}

	@Override
	public Restaurant getRestaurantByUserId(long userId) throws Exception {
		Restaurant restaurant=restaurantRepository.findByOwnerId(userId);
		if(restaurant==null) {
			throw new Exception("restaurant not found with owner id"+userId);
		}
		return restaurant;
	}

	@Override
	public RestaurantDto addToFavorites(long restaurantId, User user) throws Exception {
		Restaurant restaurant=findRestaurantById(restaurantId);
		
		RestaurantDto dto= new RestaurantDto();
		dto.setDescription(restaurant.getDescription());
		dto.setImages(restaurant.getImages());
		dto.setTitle(restaurant.getName());
		dto.setId(restaurantId);
		
		boolean isFavorited =false;
		List<RestaurantDto> favorites = user.getFavorites();
		for(RestaurantDto favorite : favorites) {
			if(favorite.getId() == (restaurantId)) {
				isFavorited = true;
				break;
			}
		}
		
		if(isFavorited) {
			favorites.removeIf(favorite -> favorite.getId() == (restaurantId));
		}
		else {
			favorites.add(dto);
		}
		userRepository.save(user);
		return dto;
	}

	@Override
	public Restaurant updateRestaurantStatus(long id) throws Exception {
		Restaurant restaurant=findRestaurantById(id);
		restaurant.setOpen(!restaurant.isOpen());
		return restaurantRepository.save(restaurant);
	}

}
