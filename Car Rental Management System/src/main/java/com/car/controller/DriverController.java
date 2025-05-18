package com.car.controller;/*
    @author Dasun
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.dto.DriverDTO;
import com.car.service.DriverService;
import com.car.util.ResponseUtil;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService service;

    @PostMapping
    public ResponseUtil saveDriver(@RequestBody DriverDTO dto){
         service.saveDriver(dto);
        return new ResponseUtil("200","Driver added",dto);
    }
}
