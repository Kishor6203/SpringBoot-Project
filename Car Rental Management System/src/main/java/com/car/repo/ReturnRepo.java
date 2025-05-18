package com.car.repo;/*
    @author Dasun
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Rent;

public interface ReturnRepo extends JpaRepository<Rent , String> {
}
