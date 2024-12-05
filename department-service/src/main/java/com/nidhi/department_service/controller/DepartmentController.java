package com.nidhi.department_service.controller;

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

import com.nidhi.department_service.model.Department;
import com.nidhi.department_service.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("Add department");
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/get")
    public List<Department> getAll(){
        LOGGER.info("Get all Department");
        return departmentRepository.getAllDepartment();
    }

    @GetMapping("/get/{id}")
    public Department getById(@PathVariable int id){
        LOGGER.info("Get all department by id");
        return departmentRepository.getDepartmentById(id);
    }
}
