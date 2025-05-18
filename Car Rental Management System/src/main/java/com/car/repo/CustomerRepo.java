package com.car.repo;/*
    @author Dasun
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer , String> {


}
