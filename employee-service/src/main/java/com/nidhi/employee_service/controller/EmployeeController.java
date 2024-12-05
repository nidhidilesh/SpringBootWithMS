package com.nidhi.employee_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nidhi.employee_service.model.Employee;
import com.nidhi.employee_service.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee){
        employeeRepository.add(employee);
        LOGGER.info("Employee added");
        return employee;
    }

    @GetMapping("/get")
    public List<Employee> getAll(){
        LOGGER.info("Get all Employees");
        return employeeRepository.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable int id){
        LOGGER.info("Get all Employees by id");
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping("/get-by-deptId/{id}")
    public List<Employee> getByDeptId(@PathVariable("id") int deptId){
        LOGGER.info("Get all Employees by department id");
        return employeeRepository.findByDepartmentId(deptId);
    }
}
