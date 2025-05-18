package com.car.service.impl;/*
    @author Dasun
*/

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dto.CarDTO;
import com.car.dto.CustomerDTO;
import com.car.entity.Car;
import com.car.entity.Customer;
import com.car.entity.Rent;
import com.car.repo.CustomerRepo;
import com.car.repo.RentRepo;
import com.car.service.CustomerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    RentRepo rentRepo;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(!repo.existsById(dto.getCustomerId())){
            repo.save(mapper.map(dto, Customer.class));
        }else {
            throw new RuntimeException("Customer already added");
        }
    }

    @Override
    public void updateCarAvailability(String rentId, String option) {
        Rent rent = rentRepo.findById(rentId).get();
        rent.getCar().setStatus("notAvailable");
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }


}
