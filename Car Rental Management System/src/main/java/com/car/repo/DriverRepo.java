package com.car.repo;/*
    @author Dasun
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Driver;

public interface DriverRepo extends JpaRepository<Driver,String> {

    Driver findByLicenceNo(String licenceNo);
}
