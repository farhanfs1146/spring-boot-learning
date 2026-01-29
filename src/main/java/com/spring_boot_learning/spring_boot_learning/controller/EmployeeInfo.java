package com.spring_boot_learning.spring_boot_learning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee-info")
//@Tag(name="Employee Info", description="Employee info relevant APIs.")
public class EmployeeInfo {

    @GetMapping()
    public ResponseEntity<?> getEmployeeList(){
        return ResponseEntity.status(HttpStatus.OK).body("List");
    }
}
