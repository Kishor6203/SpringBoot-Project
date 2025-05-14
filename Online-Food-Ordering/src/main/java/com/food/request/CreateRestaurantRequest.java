package com.food.request;

import java.util.List;

import com.food.Address;
import com.food.ContactInformation;

import lombok.Data;

@Data
public class CreateRestaurantRequest {
	private long id;
	private String name;
	private String description;
	private String cuisineType;
	private Address address;
	private ContactInformation contactInformation;
	private String opningHours;
	private List<String>images;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ContactInformation getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getOpningHours() {
		return opningHours;
	}
	public void setOpningHours(String opningHours) {
		this.opningHours = opningHours;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}

}
