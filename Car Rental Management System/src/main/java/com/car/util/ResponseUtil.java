package com.car.util;

import java.util.List;

import com.car.dto.AdminDTO;
import com.car.dto.CarDTO;
import com.car.dto.CustomerDTO;
import com.car.dto.DriverDTO;
import com.car.dto.LoginDTO;
import com.car.dto.RentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ResponseUtil {
    private String code;
    private String message;
    private Object data;

    // Constructor for String data
    public ResponseUtil(String code, String message, List<RentDTO> allRentRequest) {
        this.code = code;
        this.message = message;
        this.data = allRentRequest;
    }

    // Constructor for AdminDTO
    public ResponseUtil(String code, String message, AdminDTO data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Constructor for CustomerDTO
    public ResponseUtil(String code, String message, CustomerDTO data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Constructor for DriverDTO
    public ResponseUtil(String code, String message, DriverDTO data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Constructor for LoginDTO
    public ResponseUtil(String code, String message, LoginDTO data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Constructor for RentDTO
    public ResponseUtil(String code, String message, RentDTO data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseUtil [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
}

