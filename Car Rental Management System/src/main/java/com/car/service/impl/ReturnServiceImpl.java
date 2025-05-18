package com.car.service.impl;/*
    @author Dasun
*/


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.entity.Rent;
import com.car.repo.ReturnRepo;
import com.car.service.ReturnService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    ReturnRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void returnDriver(String rentId, String option) {
        Rent rent = repo.findById(rentId).get();
        rent.getDriver().setAvailability("Available");
        repo.save(rent);
    }


}
