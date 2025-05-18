package com.car.repo;/*
    @author Dasun
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Car;

public interface CarRepo extends JpaRepository<Car,String> {
}
