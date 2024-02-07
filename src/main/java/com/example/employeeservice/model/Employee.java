package com.example.employeeservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EMP")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private String location;

    public Employee(){}

    public Employee(int employeeId, String name, String location) {
        this.employeeId = employeeId;
        this.name = name;
        this.location = location;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
