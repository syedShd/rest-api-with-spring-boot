package com.rest.serviceapi.dao.repository;

import com.rest.serviceapi.dao.model.EmpContact;
import com.rest.serviceapi.dao.model.SearchResponse;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepository extends CrudRepository<EmpContact, Integer> {

   EmpContact findByEmail(String email);

   @Query("SELECT new com.rest.serviceapi.dao.model.SearchResponse(e.firstName, p.postalCode) FROM EmpContact e JOIN e.address p WHERE p.postalCode LIKE %:postalCode%")
   List<SearchResponse> findByPostalCodeLike(String postalCode);

//   List<SearchResponse> findByEmpContactAddressPostalCodeLike(String postalCode);


   @Query("SELECT eContact FROM EmpContact eContact WHERE eContact.firstName LIKE %:firstName%")
   List<EmpContact> searchByFirstNameLike(@Param("firstName") String firstName);
}
