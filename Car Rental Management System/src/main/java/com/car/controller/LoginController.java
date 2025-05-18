package com.car.controller;/*
    @author Dasun
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.car.dto.DriverDTO;
import com.car.dto.LoginDTO;
import com.car.service.LoginService;
import com.car.util.ResponseUtil;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService service;

    @PostMapping
    public ResponseUtil saveDriver(@RequestBody LoginDTO dto){
        service.saveLogin(dto);
        return new ResponseUtil("200","Driver added",dto);
    }

    @GetMapping(path = "/{username}")
    public ResponseUtil loginToSystem(@PathVariable String username) {
        return new ResponseUtil("200", "Ok", service.loginToSystem(username));
    }
}
