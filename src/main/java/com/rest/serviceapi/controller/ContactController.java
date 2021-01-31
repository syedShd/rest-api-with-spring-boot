package com.rest.serviceapi.controller;

import com.rest.serviceapi.dto.EmpContactDTO;
import com.rest.serviceapi.service.ContactConvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController {
  final
  ContactConvertService contactConvertService;

    public ContactController(ContactConvertService contactConvertService) {
        this.contactConvertService = contactConvertService;
    }
    //  private ContactService contactService = ContactService.getInstance();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/contact-list")
   /* MappingJacksonValue */ public List<EmpContactDTO> getContactList() {

        return new ArrayList<>(contactConvertService.findAllEmpContacts());
        /*
         To Dynamically Ignore Properties -- method return type should be MappingJacksonValue
         SimpleBeanPropertyFilter simpleBeanPropertyFilter =
         SimpleBeanPropertyFilter.serializeAllExcept("addressId");
         FilterProvider filterProvider = new SimpleFilterProvider()
                 .addFilter("userFilter", simpleBeanPropertyFilter);
         List<EmpContactDTO> contacts = new ArrayList<>(contactConvertService.findAllEmpContacts());
         MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(contacts);
         mappingJacksonValue.setFilters(filterProvider);
         return mappingJacksonValue;
        */

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/contact-list/{id}")
    public ResponseEntity<EmpContactDTO> getContactsById(@PathVariable(value = "id") int cId) {
        EmpContactDTO contact = contactConvertService.findEmpContactById(cId);
        return ResponseEntity.ok().body(contact);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/edit-contact/{id}")
    public ResponseEntity<EmpContactDTO> updateById(@PathVariable(value = "id") int employeeId, @RequestBody EmpContactDTO employeeDetails) {
        EmpContactDTO updatedEmployee = contactConvertService.updateEmpContact(employeeId, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add-contact")
    public void createEmployee(@RequestBody EmpContactDTO employeeDetails) {
        contactConvertService.addEmpContact(employeeDetails);
        //  return  ResponseEntity.ok().body(employee);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping ("/delete-contact/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int employeeId) {
        contactConvertService.removeEmpContact(employeeId);

    }

}
