package com.rest.serviceapi.dto.operations;

import com.rest.serviceapi.dto.beanpojo.EmpContactDTO;

import java.util.List;

public interface IEmpContactDTO {
    void addEmpContact(EmpContactDTO employee);
    EmpContactDTO updateEmpContact(int id, EmpContactDTO employee);
    void removeEmpContact(int id);
    EmpContactDTO findEmpContactById(int id);
    List<EmpContactDTO> findAllEmpContacts();
}
