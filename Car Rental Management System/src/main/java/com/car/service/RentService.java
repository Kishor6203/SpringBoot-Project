package com.car.service;/*
    @author Dasun
*/

import java.util.List;

import com.car.dto.RentDTO;

public interface RentService {

    void bookingCar(RentDTO dto);

    List<RentDTO> rentRequest();

    void rentCar(RentDTO dto);

     void updateDriverAvailability(String rentId, String option);

    void updateCarAvailability(String rentId, String option);

    void deleteDriver(String licenceNo);

}
