package com.spring_boot_learning.spring_boot_learning.controller;

import com.spring_boot_learning.spring_boot_learning.DTO.Requests.EmployeeInfoRequest;
import com.spring_boot_learning.spring_boot_learning.DTO.Responses.EmployeeInfoResponse;
import com.spring_boot_learning.spring_boot_learning.service.EmployeeInfoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-info")
@Tag(name="Employee Info", description="Employee info relevant APIs.")
@AllArgsConstructor
public class EmployeeInfo {

    private EmployeeInfoService employeeInfoService;

    @PostMapping
    public EmployeeInfoResponse createEmployee(@Valid @RequestBody EmployeeInfoRequest request){

        return employeeInfoService.createNewEmployee(request);
    }

    @PutMapping("{id}")
    public EmployeeInfoResponse updateEmployeeById(
            @Parameter(name = "Employee Id", required = true, example = "1")
            @PathVariable Long id,
            @Valid @RequestBody EmployeeInfoRequest request){

        return employeeInfoService.updateEmployeeById(id,request);
    }

    @GetMapping("{id}")
    public EmployeeInfoResponse getEmployeeById(
            @Parameter(name = "Employee Id", required = true, example = "1")
            @PathVariable Long id){

        return employeeInfoService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeInfoResponse> getAllEmployees(){

        return employeeInfoService.findAll();
    }

}
