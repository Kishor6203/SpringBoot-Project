package com.food.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {
	
	private long cartItemId;
	
	private int quantity;

	public long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "UpdateCartItemRequest [cartItemId=" + cartItemId + ", quantity=" + quantity + "]";
	}

	

}
