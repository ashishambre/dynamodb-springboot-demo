package com.ashish.dynamodbspringbootdemo.controller;

import com.ashish.dynamodbspringbootdemo.entity.Employee;
import com.ashish.dynamodbspringbootdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable("id") String employeeId){
        return employeeRepository.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") String employeeId){
        return employeeRepository.delete(employeeId);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") String employeeId, @RequestBody Employee employee){
        return employeeRepository.update(employee, employeeId);
    }
}
