package com.car.dto;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentDTO {

    private String rentId;
    private String date;
    private String pickupDate;
    private String returnDate;
    private String pickUpVenue;
    private String returnVenue;
    //private String lossDamageWaiver;
    private String bankSlip;
    private String status;

    private CarDTO car;
    private CustomerDTO customer;
    private DriverDTO driver;
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getPickUpVenue() {
		return pickUpVenue;
	}
	public void setPickUpVenue(String pickUpVenue) {
		this.pickUpVenue = pickUpVenue;
	}
	public String getReturnVenue() {
		return returnVenue;
	}
	public void setReturnVenue(String returnVenue) {
		this.returnVenue = returnVenue;
	}
	public String getBankSlip() {
		return bankSlip;
	}
	public void setBankSlip(String bankSlip) {
		this.bankSlip = bankSlip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CarDTO getCar() {
		return car;
	}
	public void setCar(CarDTO car) {
		this.car = car;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public DriverDTO getDriver() {
		return driver;
	}
	public void setDriver(DriverDTO driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "RentDTO [rentId=" + rentId + ", date=" + date + ", pickupDate=" + pickupDate + ", returnDate="
				+ returnDate + ", pickUpVenue=" + pickUpVenue + ", returnVenue=" + returnVenue + ", bankSlip="
				+ bankSlip + ", status=" + status + ", car=" + car + ", customer=" + customer + ", driver=" + driver
				+ "]";
	}
    
    
}
