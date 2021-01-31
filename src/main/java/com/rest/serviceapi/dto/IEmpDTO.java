package com.rest.serviceapi.dto;

import java.util.List;

public interface IEmpDTO {
    EmpDTO  addEmployee(EmpDTO employee);
    EmpDTO updateEmployee(int id, EmpDTO employee);
    EmpDTO removeEmployee(int id);
    EmpDTO findEmpByIds(int id);
    List<EmpDTO> findAllEmployees();

}
