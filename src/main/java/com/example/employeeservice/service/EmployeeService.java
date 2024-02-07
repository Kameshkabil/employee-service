package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EntityManager entityManager;

    public List<Employee> getEmployees(){
        String query = "SELECT e FROM Employee e";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        return typedQuery.getResultList();
    }


    @Transactional
    public Employee createNewAccountForEmployee(Employee employee) {
        employee.setName(employee.getName());
        employee.setLocation(employee.getLocation());
        entityManager.persist(employee);
        return employee ;
    }
}
