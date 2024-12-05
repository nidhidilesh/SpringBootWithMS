package com.nidhi.employee_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nidhi.employee_service.model.Employee;

@Repository
public class EmployeeRepository {
    
    private List<Employee> employees = new ArrayList<>();

    public Employee add(Employee employee){
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
            .filter(emp -> emp.id() == id)
            .findFirst()
            .orElseThrow();
    }

    public List<Employee> findByDepartmentId(int deptId){
        return employees.stream()
            .filter(emp -> emp.deptId() == deptId)
            .toList();
    }
}
