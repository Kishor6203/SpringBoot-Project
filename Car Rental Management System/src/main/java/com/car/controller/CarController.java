package com.car.controller;/*
    @author Dasun
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.car.dto.CarDTO;
import com.car.dto.CustomerDTO;
import com.car.dto.RentDTO;
import com.car.service.CarService;
import com.car.service.RentService;
import com.car.util.ResponseUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    public CarController(){
        System.out.println("car conterolelr");
    }

    @Autowired
    CarService service;


    @PostMapping(path = "/saveImg", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseUtil saveImage(CarDTO carDTO, 
                                  @RequestPart("imgFrontFile") MultipartFile file1, 
                                  @RequestPart("imgBackFile") MultipartFile file2, 
                                  @RequestPart("imgSideFile") MultipartFile file3, 
                                  @RequestPart("imgInsideFile") MultipartFile file4) {
        try {
            // Get the project path dynamically
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + File.separator + "uploads");
            
            // Create the directory if it doesn't exist
            if (!uploadsDir.exists()) {
                uploadsDir.mkdir();
            }

            // Transfer files to the server
            file1.transferTo(new File(uploadsDir.getAbsolutePath() + File.separator + file1.getOriginalFilename()));
            file2.transferTo(new File(uploadsDir.getAbsolutePath() + File.separator + file2.getOriginalFilename()));
            file3.transferTo(new File(uploadsDir.getAbsolutePath() + File.separator + file3.getOriginalFilename()));
            file4.transferTo(new File(uploadsDir.getAbsolutePath() + File.separator + file4.getOriginalFilename()));

            // Set image paths on the DTO
            carDTO.setFrontViewImage("uploads" + File.separator + file1.getOriginalFilename());
            carDTO.setBackView("uploads" + File.separator + file2.getOriginalFilename());
            carDTO.setSideView("uploads" + File.separator + file3.getOriginalFilename());
            carDTO.setInternalView("uploads" + File.separator + file4.getOriginalFilename());

            // Save the carDTO object
            service.saveCar(carDTO);

            // Optionally, log or print the DTO to confirm
            System.out.println(carDTO.toString());

            // Return a success response
            return new ResponseUtil("200", "Successfully Saved", carDTO);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            // Return an error response with the exception message
            return new ResponseUtil("500", "Error while saving images: " + e.getMessage(), null);
        }
    }


    @GetMapping
    public ResponseUtil getAllCars(){
        List<RentDTO> allCar = service.getAllCars();
        return new ResponseUtil("OK","Successfull",allCar);

    }

}
