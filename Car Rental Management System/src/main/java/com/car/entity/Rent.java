package com.car.entity;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Rent {

    @Id
    private String rentId;

    private String date;
    private String pickupDate;
    private String returnDate;
    private String pickUpVenue;
    private String returnVenue;
    //private String lossDamageWaiver;
    //private String bankSlip;
    private String status;



    @ManyToOne
    @JoinColumn(name = "licenceNo",referencedColumnName = "licenceNo")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "registrationNO" , referencedColumnName = "registrationNO")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Rent [rentId=" + rentId + ", date=" + date + ", pickupDate=" + pickupDate + ", returnDate=" + returnDate
				+ ", pickUpVenue=" + pickUpVenue + ", returnVenue=" + returnVenue + ", status=" + status + ", driver="
				+ driver + ", car=" + car + ", customer=" + customer + "]";
	}
    
    




}
