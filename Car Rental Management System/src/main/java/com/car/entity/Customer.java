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
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String address;
    private int contactNo;
    private String email;
    private String nicNo;
    private String licenceNo;
    private String userName;
    private String password;
    private String nicFrontImage;
    private String nicBackImage;
    private String licenceImage;

    //private String status;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNicNo() {
		return nicNo;
	}

	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNicFrontImage() {
		return nicFrontImage;
	}

	public void setNicFrontImage(String nicFrontImage) {
		this.nicFrontImage = nicFrontImage;
	}

	public String getNicBackImage() {
		return nicBackImage;
	}

	public void setNicBackImage(String nicBackImage) {
		this.nicBackImage = nicBackImage;
	}

	public String getLicenceImage() {
		return licenceImage;
	}

	public void setLicenceImage(String licenceImage) {
		this.licenceImage = licenceImage;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", contactNo="
				+ contactNo + ", email=" + email + ", nicNo=" + nicNo + ", licenceNo=" + licenceNo + ", userName="
				+ userName + ", password=" + password + ", nicFrontImage=" + nicFrontImage + ", nicBackImage="
				+ nicBackImage + ", licenceImage=" + licenceImage + ", rents=" + rents + "]";
	}
    
    
}
