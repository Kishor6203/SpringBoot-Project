package com.car.entity;/*
    @author Dasun
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id

    private String registrationNO;
    private String brand;
    private String type;
    private int NoOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String color;
    private double dailyRate;
    private double monthlyRate;
    private double lossDamageWaiver;
    private double priceForExtraKm;
    private double freeMileage;
    private String status;

    private String frontViewImage;
    private String backView;
    private String sideView;
    private String internalView;


    @OneToMany(mappedBy = "car" , cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();


	public String getRegistrationNO() {
		return registrationNO;
	}


	public void setRegistrationNO(String registrationNO) {
		this.registrationNO = registrationNO;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNoOfPassengers() {
		return NoOfPassengers;
	}


	public void setNoOfPassengers(int noOfPassengers) {
		NoOfPassengers = noOfPassengers;
	}


	public String getTransmissionType() {
		return transmissionType;
	}


	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getDailyRate() {
		return dailyRate;
	}


	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}


	public double getMonthlyRate() {
		return monthlyRate;
	}


	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}


	public double getLossDamageWaiver() {
		return lossDamageWaiver;
	}


	public void setLossDamageWaiver(double lossDamageWaiver) {
		this.lossDamageWaiver = lossDamageWaiver;
	}


	public double getPriceForExtraKm() {
		return priceForExtraKm;
	}


	public void setPriceForExtraKm(double priceForExtraKm) {
		this.priceForExtraKm = priceForExtraKm;
	}


	public double getFreeMileage() {
		return freeMileage;
	}


	public void setFreeMileage(double freeMileage) {
		this.freeMileage = freeMileage;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getFrontViewImage() {
		return frontViewImage;
	}


	public void setFrontViewImage(String frontViewImage) {
		this.frontViewImage = frontViewImage;
	}


	public String getBackView() {
		return backView;
	}


	public void setBackView(String backView) {
		this.backView = backView;
	}


	public String getSideView() {
		return sideView;
	}


	public void setSideView(String sideView) {
		this.sideView = sideView;
	}


	public String getInternalView() {
		return internalView;
	}


	public void setInternalView(String internalView) {
		this.internalView = internalView;
	}


	public List<Rent> getRents() {
		return rents;
	}


	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}


	@Override
	public String toString() {
		return "Car [registrationNO=" + registrationNO + ", brand=" + brand + ", type=" + type + ", NoOfPassengers="
				+ NoOfPassengers + ", transmissionType=" + transmissionType + ", fuelType=" + fuelType + ", color="
				+ color + ", dailyRate=" + dailyRate + ", monthlyRate=" + monthlyRate + ", lossDamageWaiver="
				+ lossDamageWaiver + ", priceForExtraKm=" + priceForExtraKm + ", freeMileage=" + freeMileage
				+ ", status=" + status + ", frontViewImage=" + frontViewImage + ", backView=" + backView + ", sideView="
				+ sideView + ", internalView=" + internalView + ", rents=" + rents + "]";
	}

    



}
