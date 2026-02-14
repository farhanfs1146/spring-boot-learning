package com.spring_boot_learning.spring_boot_learning.DTO.Requests;

import com.spring_boot_learning.spring_boot_learning.enums.EmployeeType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class EmployeeInfoRequest {

    @NotNull(message = "Employee card Number can not be empty or invalid.")
    @Schema(description = "Employee card number must be provided", example = "13411")
    @Size(max = 100, min = 1)
    private Long cardNo;

    @NotBlank(message = "Employee name can not be empty or invalid.")
    @Schema(description = "Employee name must be provided", example = "Farhan")
    @Size(max = 150, min = 3)
    private String employeeName;

    @NotBlank(message = "Employee father name can not be empty or invalid.")
    @Size(min = 3, max = 150)
    @Schema(description = "Employee father name must be provided", example = "Tariq")
    private String fatherName;

    @NotBlank(message = "Employee contact can not be empty or invalid.")
    @Size(min = 11, max = 15)
    @Schema(description = "Employee contact must be provided", example = "0323566886")
    private String contactNo;

    @NotNull(message = "Employee type can not be empty or invalid.")
    @Schema(description = "Employee Type", example = "LABOUR")
    private EmployeeType employeeType;

    @Schema(description = "Employee status must be provided.", example = "true")
    private Boolean isActive;
}
