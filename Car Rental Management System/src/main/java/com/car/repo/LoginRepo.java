package com.car.repo;/*
    @author Dasun
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Login;

public interface LoginRepo extends JpaRepository<Login,String> {
}
