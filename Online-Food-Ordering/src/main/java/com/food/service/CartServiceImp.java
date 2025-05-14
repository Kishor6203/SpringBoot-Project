package com.food.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Cart;
import com.food.CartItem;
import com.food.Food;
import com.food.User;
import com.food.repository.CartItemRepository;
import com.food.repository.CartRepository;
import com.food.repository.FoodRepository;
import com.food.request.AddCartItemRequest;

@Service
public class CartServiceImp implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private FoodService foodService;

	@Override
	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {
		User user=userService.findUserByJwtToken(jwt);
		Food food=foodService.findFoodById(req.getFoodId());
		Cart cart=cartRepository.findByCustomerId(user.getId());
		
		for(CartItem cartItem : cart.getItems()) {
			if(cartItem.getFood().equals(food)) {
				int newQuantity=cartItem.getQuantity()+req.getQuantity();
				return updateCartItemQuantity(cartItem.getId(), newQuantity);
			}
		}
		
		CartItem newCartItem=new CartItem();
		newCartItem.setFood(food);
		newCartItem.setCart(cart);
		newCartItem.setQuantity(req.getQuantity());
		newCartItem.setIngredients(req.getIngredients());
		newCartItem.setTotalPrice(req.getQuantity()*food.getPrice());
		
		CartItem saveCartItem=cartItemRepository.save(newCartItem);
		cart.getItems().add(saveCartItem);
		return saveCartItem;
	}

	@Override
	public CartItem updateCartItemQuantity(long cartItemId, int quantity) throws Exception {
		Optional<CartItem> cartItemOptional=cartItemRepository.findById(cartItemId);
		if(cartItemOptional.isEmpty()) {
			throw new Exception("cart item not found");
		}
		CartItem item=cartItemOptional.get();
		item.setQuantity(quantity);
		
		//5*100=500
		
		item.setTotalPrice(item.getFood().getPrice()*quantity);
		return cartItemRepository.save(item);
	}

	@Override
	public Cart removeItemFromCart(long cartItemId, String jwt) throws Exception {
		User user=userService.findUserByJwtToken(jwt);
		Cart cart=cartRepository.findByCustomerId(user.getId());
		
		Optional<CartItem> cartItemOptional=cartItemRepository.findById(cartItemId);
		if(cartItemOptional.isEmpty()) {
			throw new Exception("cart item not found");
		}
		CartItem item=cartItemOptional.get();
		cart.getItems().remove(item);
		return cartRepository.save(cart);
	}

	@Override
	public long calculateCartTotals(Cart cart) throws Exception {
		long total=0l;
		for(CartItem cartItem : cart.getItems()) {
			total+=cartItem.getFood().getPrice()*cartItem.getQuantity();
		}
		return total;
	}

	@Override
	public Cart finfCartById(long id) throws Exception {
		Optional<Cart> optionalCart=cartRepository.findById(id);
		if(optionalCart.isEmpty()) {
			throw new Exception("cart not found with id "+id);
		}
		return optionalCart.get();
	}

	@Override
	public Cart findCartByUserId(long userId) throws Exception {
		//User user=userService.findUserByJwtToken(jwt);
		Cart cart= cartRepository.findByCustomerId(userId);
		cart.setTotal(calculateCartTotals(cart));
		return cart;
	}

	@Override
	public Cart clearCart(long userId) throws Exception {
		//User user=userService.findUserByJwtToken(jwt);
		Cart cart=findCartByUserId(userId);
		cart.getItems().clear();
		return cartRepository.save(cart);
	}
	
	

}
