package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.projection.DepartmentProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query methods
    Optional<Department> findByName(String name);
    List<Department> findByNameContaining(String name);
    
    // Custom query methods
    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :employeeCount")
    List<Department> findDepartmentsWithMoreThanXEmployees(@Param("employeeCount") int employeeCount);
    
    // Named queries
    @Query(name = "Department.findByNameContaining")
    List<Department> findDepartmentsByNameContaining(@Param("name") String name);
    
    // Pagination and sorting
    Page<Department> findByNameContaining(String name, Pageable pageable);
    
    // Projections
    @Query("SELECT d.id as id, d.name as name, SIZE(d.employees) as employeeCount FROM Department d")
    List<DepartmentProjection> findDepartmentProjections();
}