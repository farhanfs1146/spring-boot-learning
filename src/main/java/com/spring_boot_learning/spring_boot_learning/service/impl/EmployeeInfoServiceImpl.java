package com.spring_boot_learning.spring_boot_learning.service.impl;

import com.spring_boot_learning.spring_boot_learning.DTO.Requests.EmployeeInfoRequest;
import com.spring_boot_learning.spring_boot_learning.DTO.Responses.EmployeeInfoResponse;
import com.spring_boot_learning.spring_boot_learning.entity.EmployeeInfo;
import com.spring_boot_learning.spring_boot_learning.repository.EmployeeInfoRepository;
import com.spring_boot_learning.spring_boot_learning.service.EmployeeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    private final EmployeeInfoRepository employeeInfoRepository;

    @Override
    public EmployeeInfoResponse createNewEmployee(EmployeeInfoRequest request) {

        // existence check
        if (employeeInfoRepository.existsByCardNo(request.getCardNo())){

            throw new RuntimeException("Employee Card No. " + request.getCardNo() + " you're trying to create already assigned to another employee.");
        }
        // if not exist save it as new.
        EmployeeInfo employeeInfo = EmployeeInfo.builder()
                .cardNo(request.getCardNo())
                .employeeName(request.getEmployeeName())
                .fatherName(request.getFatherName())
                .contactNo(request.getContactNo())
                .isActive(request.getIsActive())
                .build();

        var savedEmployee = employeeInfoRepository.save(employeeInfo);
        return mapResponse(savedEmployee);
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

    private EmployeeInfoResponse mapResponse(EmployeeInfo savedEmployee) {

        return new EmployeeInfoResponse(savedEmployee.getId(), savedEmployee.getCardNo(), savedEmployee.getEmployeeName(), savedEmployee.getFatherName(), savedEmployee.getContactNo(), savedEmployee.getIsActive());
    }
}
