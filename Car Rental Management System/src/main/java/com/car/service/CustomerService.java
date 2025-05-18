package com.car.service;/*
    @author Dasun
*/

import java.util.List;

import com.car.dto.CarDTO;
import com.car.dto.CustomerDTO;

public interface CustomerService {

    void saveCustomer(CustomerDTO dto);

    void updateCarAvailability(String rentId, String option);

    List<CustomerDTO> getAllCustomers();



}
