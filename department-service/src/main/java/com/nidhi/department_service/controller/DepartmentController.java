package com.nidhi.department_service.controller;

import java.util.List;

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

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/get")
    public List<Department> getAll(){
        return departmentRepository.getAllDepartment();
    }

    @GetMapping("/get/{id}")
    public Department getById(@PathVariable int id){
        return departmentRepository.getDepartmentById(id);
    }
}
