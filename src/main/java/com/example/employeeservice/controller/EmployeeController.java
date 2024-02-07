package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @PostMapping("/api/create-employees")
    public Employee createNewAccountForEmployee(@RequestBody Employee employee){
        return employeeService.createNewAccountForEmployee(employee);
    }

}
