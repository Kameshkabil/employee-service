package com.example.employeeservice.service;

import com.example.employeeservice.exception.UserNotFound;
import com.example.employeeservice.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@jakarta.transaction.Transactional
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

    @Cacheable(key = "#id", value = "Employee")
    public Employee getParticularEmployeeById(int id){
        System.out.println("Fetch Data From Database");
        Employee employee = entityManager.find(Employee.class,id);
        if (employee!=null){
            return employee;
        }else {
            throw new UserNotFound("User Not Found");
        }
    }

    @CacheEvict(key = "#id",value = "Employee")
    public String deleteParticularEmployeeId(int id){
        Employee employee = entityManager.find(Employee.class,id);
        if (employee!=null){
            entityManager.remove(employee);
            return "Removed Successfully";
        }else {
            throw new UserNotFound("User Not Found");
        }
    }


    @CachePut(key = "#id",value = "Employee")
    public Employee updateEmployeeById(int id,Employee employee1){
        Employee employee = entityManager.find(Employee.class,id);
        if (employee!=null){
            return entityManager.merge(employee1);
        }else {
            throw new UserNotFound("User Not Found");
        }
    }
}
