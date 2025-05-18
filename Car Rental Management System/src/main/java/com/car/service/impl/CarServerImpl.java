package com.car.service.impl;/*
    @author Dasun
*/

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dto.CarDTO;
import com.car.entity.Car;
import com.car.entity.Customer;
import com.car.repo.CarRepo;
import com.car.service.CarService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServerImpl implements CarService {

    @Autowired
    CarRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if(!repo.existsById(dto.getRegistrationNO())){
        repo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("car already added");

        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<CarDTO>>(){}.getType());
    }


}
