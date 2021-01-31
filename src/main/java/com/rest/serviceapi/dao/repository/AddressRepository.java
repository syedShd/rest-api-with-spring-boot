package com.rest.serviceapi.dao.repository;

import com.rest.serviceapi.dao.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {


}
