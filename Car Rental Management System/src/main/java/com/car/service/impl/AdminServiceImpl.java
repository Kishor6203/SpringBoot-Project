package com.car.service.impl;/*
    @author Dasun
*/

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dto.AdminDTO;
import com.car.entity.Admin;
import com.car.repo.AdminRepo;
import com.car.service.AdminService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminId())){
            repo.save(mapper.map(dto,Admin.class));
        }else {
            throw new RuntimeException("Admin Already Exists");
        }
    }
}
