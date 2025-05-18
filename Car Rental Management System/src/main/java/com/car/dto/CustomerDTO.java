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
public class CustomerDTO {

    private String customerId;
    private String name;
    private String address;
    private int contactNo;
    private String email;
    private String nicNo;
    private String nicFrontImage;
    private String nicBackImage;
    private String licenceNo;
    private String licenceImage;
    private String userName;
    private String password;
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
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public String getLicenceImage() {
		return licenceImage;
	}
	public void setLicenceImage(String licenceImage) {
		this.licenceImage = licenceImage;
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
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", address=" + address + ", contactNo="
				+ contactNo + ", email=" + email + ", nicNo=" + nicNo + ", nicFrontImage=" + nicFrontImage
				+ ", nicBackImage=" + nicBackImage + ", licenceNo=" + licenceNo + ", licenceImage=" + licenceImage
				+ ", userName=" + userName + ", password=" + password + "]";
	}
    
    
}
