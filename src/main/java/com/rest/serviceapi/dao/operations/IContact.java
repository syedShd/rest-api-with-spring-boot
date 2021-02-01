package com.rest.serviceapi.dao.operations;

import com.rest.serviceapi.dao.model.EmpContact;

import java.util.List;

public interface IContact {
    EmpContact addEmpContact(EmpContact employee);
    EmpContact updateEmpContact(int id, EmpContact employee);
    EmpContact removeEmpContact(int id);
    EmpContact getContactById(int id);
    List<EmpContact> getAllContacts();
}
