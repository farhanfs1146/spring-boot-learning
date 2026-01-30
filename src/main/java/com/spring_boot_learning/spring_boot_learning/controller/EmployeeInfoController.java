package com.spring_boot_learning.spring_boot_learning.controller;

import com.spring_boot_learning.spring_boot_learning.DTO.Requests.EmployeeInfoRequest;
import com.spring_boot_learning.spring_boot_learning.DTO.Responses.EmployeeInfoResponse;
import com.spring_boot_learning.spring_boot_learning.service.EmployeeInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-info")
@Tag(name="Employee Info", description="Employee info relevant APIs.")
@RequiredArgsConstructor
public class EmployeeInfoController {

    private final EmployeeInfoService employeeInfoService;

    @PostMapping
    public EmployeeInfoResponse createEmployee(@Valid @RequestBody EmployeeInfoRequest request){

        return employeeInfoService.createNewEmployee(request);
    }

    @Operation(summary = "Update employee by ID")
    @PutMapping("/{id}")
    public EmployeeInfoResponse updateEmployeeById(
            @Parameter(description = "Employee Id", required = true, example = "1")
            @PathVariable("id") Long id,
            @Valid @RequestBody EmployeeInfoRequest request){

        return employeeInfoService.updateEmployeeById(id,request);
    }

//    @Operation(summary = "Update employee by ID")
//    @PutMapping("/{id}")
//    public ResponseEntity<EmployeeInfoResponse> updateEmployeeById(
//            @Parameter(description = "Employee Id", required = true, example = "1")
//            @PathVariable("id") Long id,
//            @Valid @RequestBody EmployeeInfoRequest request) {
//
//        EmployeeInfoResponse response = employeeInfoService.updateEmployeeById(id, request);
//        return ResponseEntity.ok(response);
//    }


    @GetMapping("{id}")
    public EmployeeInfoResponse getEmployeeById(
            @Parameter(description = "Employee Id", required = true, example = "1")
            @PathVariable Long id){

        return employeeInfoService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeInfoResponse> getAllEmployees(){

        return employeeInfoService.findAll();
    }

}
