package com.example.employeeservice.controller;

import com.example.employeeservice.exception.UserNotFound;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        if(employeeService.getEmployees().isEmpty()){
            throw new UserNotFound("No Employees");
        }
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
    @PostMapping("/api/create-employees")
    public ResponseEntity<Employee> createNewAccountForEmployee(@RequestBody Employee employee){
        Employee employee1 =  employeeService.createNewAccountForEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Employee> getParticularEmployeeById(@PathVariable int id){
        Employee employee = employeeService.getParticularEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/api/employee/{id}")
    public ResponseEntity<String> deleteParticularEmployeeId(@PathVariable int id){
        return new ResponseEntity<>(employeeService.deleteParticularEmployeeId(id),HttpStatus.OK);
    }

    @PutMapping("/api/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployeeById(id,employee),HttpStatus.OK);
    }
}
