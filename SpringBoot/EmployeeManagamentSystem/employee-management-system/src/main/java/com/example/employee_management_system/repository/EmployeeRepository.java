package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.projection.EmployeeSummaryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Derived query methods
    List<Employee> findByNameContaining(String name);
    List<Employee> findByEmailContaining(String email);
    List<Employee> findByDepartmentName(String departmentName);
    Optional<Employee> findByEmail(String email);
    
    // Custom query methods
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);
    
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name% AND e.department.name = :departmentName")
    List<Employee> findByNameAndDepartmentName(@Param("name") String name, @Param("departmentName") String departmentName);
    
    // Named queries
    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);
    
    @Query(name = "Employee.findByEmailContaining")
    List<Employee> findEmployeesByEmailContaining(@Param("email") String email);
    
    // Pagination and sorting
    Page<Employee> findByNameContaining(String name, Pageable pageable);
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
    
    // Projections
    List<EmployeeProjection> findProjectedBy();
    List<EmployeeSummaryProjection> findByDepartmentId(Long departmentId);
    
    @Query("SELECT e.name as name, e.email as email FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeSummaryProjection> findEmployeeSummaryByDepartmentName(@Param("departmentName") String departmentName);
}