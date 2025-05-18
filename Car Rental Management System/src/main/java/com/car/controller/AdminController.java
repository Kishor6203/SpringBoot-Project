package com.car.controller;/*
    @author Dasun
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.car.dto.AdminDTO;
import com.car.service.AdminService;
import com.car.util.ResponseUtil;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;




    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO dto){
        service.saveAdmin(dto);
        return new ResponseUtil("201","Admin added",dto);
    }
}
