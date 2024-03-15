package com.example.swaggermaven.controller;

import com.example.batch.model.EmployeeRequest;
import com.example.batch.model.EmployeeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @PostMapping("api/employee")
    EmployeeResponse getEmployee(@RequestBody(required = false) EmployeeRequest employeeRequest){
        EmployeeResponse response= new EmployeeResponse();
        response.setId(1);
        response.setName("Arun");
        response.setDateOfBirth(LocalDate.now());
        return response;
    }

}
