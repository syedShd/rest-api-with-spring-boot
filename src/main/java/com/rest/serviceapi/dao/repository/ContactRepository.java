package com.rest.serviceapi.dao.repository;

import com.rest.serviceapi.dao.model.EmpContact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<EmpContact, Integer> {


}
