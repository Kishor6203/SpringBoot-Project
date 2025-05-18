package com.car.service.impl;/*
    @author Dasun
*/

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dto.LoginDTO;
import com.car.entity.Login;
import com.car.repo.LoginRepo;
import com.car.service.LoginService;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveLogin(LoginDTO dto) {
            loginRepo.save(mapper.map(dto,Login.class));
    }

    @Override
    public LoginDTO loginToSystem(String username) {
        if (loginRepo.existsById(username)) {
            return mapper.map(loginRepo.findById(username).get(),LoginDTO.class);
        }else {
            throw new RuntimeException("Driver Not Found...");

        }

        }
}
