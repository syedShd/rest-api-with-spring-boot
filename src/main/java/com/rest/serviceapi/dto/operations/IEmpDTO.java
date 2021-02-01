package com.rest.serviceapi.dto.operations;

import com.rest.serviceapi.dto.beanpojo.EmpDTO;

import java.util.List;

public interface IEmpDTO {
    EmpDTO addEmployee(EmpDTO employee);
    EmpDTO updateEmployee(int id, EmpDTO employee);
    EmpDTO removeEmployee(int id);
    EmpDTO findEmpById(int id);
    List<EmpDTO> findAllEmployees();

}
