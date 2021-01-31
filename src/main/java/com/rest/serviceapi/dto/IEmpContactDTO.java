package com.rest.serviceapi.dto;

import java.util.List;

public interface IEmpContactDTO {
    EmpContactDTO addEmpContact(EmpContactDTO employee);
    EmpContactDTO updateEmpContact(int id, EmpContactDTO employee);
    EmpContactDTO removeEmpContact(int id);
    EmpContactDTO findEmpContactById(int id);
    List<EmpContactDTO> findAllEmpContacts();
}
