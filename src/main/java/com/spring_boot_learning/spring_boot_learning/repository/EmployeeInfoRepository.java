package com.spring_boot_learning.spring_boot_learning.repository;

import com.spring_boot_learning.spring_boot_learning.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {
    boolean existsByCardNo(Long cardNo);
}
