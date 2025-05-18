package com.car.service.impl;/*
    @author Dasun
*/

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dto.DriverDTO;
import com.car.entity.Driver;
import com.car.repo.DriverRepo;
import com.car.service.DriverService;

import javax.transaction.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getLicenceNo())){
            repo.save(mapper.map(dto, Driver.class));
        }else {
            throw new RuntimeException("Driver Already Added");
        }
    }
}
