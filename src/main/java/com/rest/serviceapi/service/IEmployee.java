package com.rest.serviceapi.service;

import com.rest.serviceapi.dao.model.Employee;

import java.util.List;

public interface IEmployee {
    Employee  addEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    Employee removeEmployee(int id);
    Employee getEmpByIds(int id);
    List<Employee> getAllEmployees();

}
