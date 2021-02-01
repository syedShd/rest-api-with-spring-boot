package com.rest.serviceapi.dao.operations;

import com.rest.serviceapi.dao.model.EmpContact;
import com.rest.serviceapi.dao.model.SearchResponse;

import java.util.List;

public interface IContact {
    EmpContact addEmpContact(EmpContact employee);
    EmpContact updateEmpContact(int id, EmpContact employee);
    EmpContact removeEmpContact(int id);
    EmpContact getContactById(int id);
    List<EmpContact> getAllContacts();
    EmpContact getContactByEmail(String email);
    List<EmpContact> getAllContactsByFirstNameLike(String firstName);
    List<SearchResponse> getByPostalCodeLike(String postalCode);
}
