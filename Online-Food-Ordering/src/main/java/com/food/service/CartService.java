package com.food.service;

import com.food.Cart;
import com.food.CartItem;
import com.food.request.AddCartItemRequest;

public interface CartService {
	
	public CartItem addItemToCart(AddCartItemRequest req, String jwt)throws Exception;
	
	public CartItem updateCartItemQuantity(long cartItemId, int quantity)throws Exception;
	
	public Cart removeItemFromCart(long cartItemId, String jwt) throws Exception;
	
	public long calculateCartTotals(Cart cart)throws Exception;
	
	public Cart finfCartById(long id)throws Exception;
	
	public Cart findCartByUserId(long userId)throws Exception;
	
	public Cart clearCart(long userId)throws Exception;

}
