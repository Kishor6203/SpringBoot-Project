package com.car.service;/*
    @author Dasun
*/

import com.car.dto.DriverDTO;
import com.car.dto.LoginDTO;

public interface LoginService {

    void saveLogin (LoginDTO dto);

    LoginDTO loginToSystem(String username);


}
