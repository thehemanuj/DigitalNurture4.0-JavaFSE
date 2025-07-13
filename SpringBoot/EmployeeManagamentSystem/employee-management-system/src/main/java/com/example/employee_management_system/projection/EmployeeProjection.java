package com.example.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    Long getId();
    String getName();
    String getEmail();
    
    @Value("#{target.department.name}")
    String getDepartmentName();
}
javapackage com.example.employeemanagementsystem.projection;

public interface EmployeeSummaryProjection {
    String getName();
    String getEmail();
}