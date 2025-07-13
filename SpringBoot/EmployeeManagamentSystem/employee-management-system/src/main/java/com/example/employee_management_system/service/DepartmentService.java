package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.projection.DepartmentProjection;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {
    
    private final DepartmentRepository departmentRepository;
    
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }
    
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    
    public Optional<Department> getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
    
    public List<Department> searchDepartmentsByName(String name) {
        return departmentRepository.findByNameContaining(name);
    }
    
    public Page<Department> getDepartmentsWithPagination(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
    
    public List<DepartmentProjection> getDepartmentProjections() {
        return departmentRepository.findDepartmentProjections();
    }
}