package com.car.service;/*
    @author Dasun
*/

import java.util.List;

import com.car.dto.CarDTO;
import com.car.dto.CustomerDTO;

public interface CarService {

    void saveCar(CarDTO dto);

    List<CarDTO> getAllCars();
}
