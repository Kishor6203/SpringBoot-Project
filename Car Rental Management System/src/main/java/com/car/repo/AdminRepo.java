package com.car.repo;/*
    @author Dasun
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,String > {
}
