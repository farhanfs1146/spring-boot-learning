package com.spring_boot_learning.spring_boot_learning.DTO.Responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class EmployeeInfoResponse {

    private Long id;

    private Long cardNo;

    private String employeeName;

    private String fatherName;

    private String contactNo;

    private String employeeType;

    private Boolean isActive;

}
