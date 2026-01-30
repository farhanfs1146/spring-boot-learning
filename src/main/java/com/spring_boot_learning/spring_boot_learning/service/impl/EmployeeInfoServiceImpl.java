package com.spring_boot_learning.spring_boot_learning.service.impl;

import com.spring_boot_learning.spring_boot_learning.DTO.Requests.EmployeeInfoRequest;
import com.spring_boot_learning.spring_boot_learning.DTO.Responses.EmployeeInfoResponse;
import com.spring_boot_learning.spring_boot_learning.service.EmployeeInfoService;

import java.util.List;

public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    @Override
    public EmployeeInfoResponse createNewEmployee(EmployeeInfoRequest request) {
        return null;
    }

    @Override
    public EmployeeInfoResponse updateEmployeeById(Long id, EmployeeInfoRequest request) {
        return null;
    }

    @Override
    public EmployeeInfoResponse getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeInfoResponse> findAll() {
        return List.of();
    }

    @Override
    public EmployeeInfoResponse deleteEmployeeById(Long id) {
        return null;
    }
}
