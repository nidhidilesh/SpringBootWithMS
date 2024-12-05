package com.nidhi.department_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nidhi.department_service.model.Department;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department){
        departments.add(department);
        return department;
    }

    public List<Department> getAllDepartment() {
        return departments;
    }
    public Department getDepartmentById(int id){
        return departments.stream()
            .filter(dept -> dept.getId() == id)
            .findFirst()
            .orElseThrow();
    }
}
