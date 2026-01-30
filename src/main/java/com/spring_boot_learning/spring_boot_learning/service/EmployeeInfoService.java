package com.spring_boot_learning.spring_boot_learning.service;

import com.spring_boot_learning.spring_boot_learning.DTO.Requests.EmployeeInfoRequest;
import com.spring_boot_learning.spring_boot_learning.DTO.Responses.EmployeeInfoResponse;

import java.util.List;

public interface EmployeeInfoService {

    public EmployeeInfoResponse createNewEmployee(EmployeeInfoRequest request);

    public EmployeeInfoResponse updateEmployeeById(Long id, EmployeeInfoRequest request);

    public EmployeeInfoResponse getEmployeeById(Long id);

    public List<EmployeeInfoResponse> findAll();

    public EmployeeInfoResponse deleteEmployeeById(Long id);

}
