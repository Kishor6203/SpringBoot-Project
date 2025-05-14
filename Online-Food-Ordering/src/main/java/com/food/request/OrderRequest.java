package com.food.request;

import com.food.Address;

import lombok.Data;

@Data
public class OrderRequest {
	
	private long restaurantId;
	
	private Address deliveryAddress;

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "OrderRequest [restaurantId=" + restaurantId + ", deliveryAddress=" + deliveryAddress + "]";
	}
	
	

}
