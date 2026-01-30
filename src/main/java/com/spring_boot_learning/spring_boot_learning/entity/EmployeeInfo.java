package com.spring_boot_learning.spring_boot_learning.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "card_no", nullable = false, unique = true, length = 100)
    private Long cardNo;

    @Column(name = "employee_name", nullable = false, length = 150)
    private String employeeName;

    @Column(name = "father_name", nullable = false, length = 150)
    private String fatherName;

    @Column(name = "contact_no", nullable = false, length = 15)
    private String contactNo;

    @Column(name = "is_active", nullable = false) // Database level constraint
    private Boolean isActive = true; // set default Java-Base Level default.
}
