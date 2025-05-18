package com.car.controller;/*
    @author Dasun
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.car.service.ReturnService;
import com.car.util.ResponseUtil;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    ReturnService returnService;


    @PutMapping(params = "rentId")
    public ResponseUtil returnDriver(@RequestParam String rentId, @RequestParam String option){
        returnService.returnDriver(rentId , option);
        return new ResponseUtil("ok" ,"booking successful"," ");
    }



}

