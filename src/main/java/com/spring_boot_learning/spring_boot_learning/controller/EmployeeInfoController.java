package com.spring_boot_learning.spring_boot_learning.controller;

import com.spring_boot_learning.spring_boot_learning.APIResponse.APIResponse;
import com.spring_boot_learning.spring_boot_learning.DTO.Requests.EmployeeInfoRequest;
import com.spring_boot_learning.spring_boot_learning.DTO.Responses.EmployeeInfoResponse;
import com.spring_boot_learning.spring_boot_learning.service.EmployeeInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<APIResponse<EmployeeInfoResponse>> createEmployee(@Valid @RequestBody EmployeeInfoRequest request){

        var newEmployee =  employeeInfoService.createNewEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(APIResponse.success("New employee record has been created", newEmployee));
    }

    @Operation(summary = "Update employee by ID")
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<EmployeeInfoResponse>> updateEmployeeById(
            @Parameter(description = "Employee Id", required = true, example = "1")
            @PathVariable("id") Long id,
            @Valid @RequestBody EmployeeInfoRequest request){

        var updatedEmployee = employeeInfoService.updateEmployeeById(id,request);
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.success("Employee data updated successfully.", updatedEmployee));
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponse<EmployeeInfoResponse>> getEmployeeById(
            @Parameter(description = "Employee Id", required = true, example = "1")
            @PathVariable Long id){

        var existingEmployee = employeeInfoService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.success("Required employee found", existingEmployee));
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<EmployeeInfoResponse>>> getAllEmployees(){

        var employeesList =  employeeInfoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.success("List of all employees", employeesList));
    }

}
