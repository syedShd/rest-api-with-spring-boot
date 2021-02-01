package com.rest.serviceapi.service.converters;

import com.rest.serviceapi.dao.model.Address;
import com.rest.serviceapi.dao.model.EmpContact;
import com.rest.serviceapi.dao.repository.AddressRepository;
import com.rest.serviceapi.dto.beanpojo.AddressDTO;
import com.rest.serviceapi.dto.beanpojo.EmpContactDTO;
import com.rest.serviceapi.dto.operations.IEmpContactDTO;
import com.rest.serviceapi.service.providers.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactConvertService implements IEmpContactDTO {
    @Autowired
    private ContactService contactService;
    @Autowired
    private  AddressRepository addressRepository;

    @Override
    public void addEmpContact(EmpContactDTO employee) {
        convertToEmpContactDTO(contactService.addEmpContact(convertToEmpContact(employee)));
    }


    @Override
    public EmpContactDTO updateEmpContact(int id, EmpContactDTO employee) {
        return convertToEmpContactDTO(contactService.updateEmpContact(id, convertToEmpContact(employee)));
    }

    @Override
    public void removeEmpContact(int id) {
        convertToEmpContactDTO(contactService.removeEmpContact(id));
    }

    @Override
    public EmpContactDTO findEmpContactById(int id) {
        return convertToEmpContactDTO(contactService.getContactById(id));
    }

    @Override
    public List<EmpContactDTO> findAllEmpContacts() {
        return listToEmpContactDTO(contactService.getAllContacts());
    }

    private List<EmpContactDTO> listToEmpContactDTO(List<EmpContact> allContacts) {
        return allContacts.stream().map(this::convertToEmpContactDTO).collect(Collectors.toList());
    }

    // DAO to DTO
    private EmpContactDTO convertToEmpContactDTO(EmpContact empContact) {
        EmpContactDTO empContactDTO = new EmpContactDTO();
        empContactDTO.setId(empContact.getId());
        empContactDTO.setFirstName(empContact.getFirstName());
        empContactDTO.setLastName(empContact.getLastName());
        empContactDTO.setEmail(empContact.getEmail());
        empContactDTO.setMobile(empContact.getMobile());
        empContactDTO.setAddress(convertToEmpAddressDTO(empContact.getAddress()));
        return  empContactDTO;
    }


    // DTO to DAO
    private EmpContact convertToEmpContact(EmpContactDTO employee) {
        EmpContact emp = new EmpContact();
        emp.setId(employee.getId());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        emp.setMobile(employee.getMobile());
        emp.setAddress(convertToEmpAddress(employee.getAddress()));
        return emp;
    }

    // DTO to DAO
    private Address convertToEmpAddress(AddressDTO address) {
        Address addr = new Address();
        addr.setaddressId(address.getaddressId());
        addr.setCity(address.getCity());
        addr.setDoorNo(address.getDoorNo());
        addr.setStreet(address.getStreet());
        addr.setState(address.getState());
        addr.setPostalCode(address.getPostalCode());

        return  addressRepository.save(addr);
    }

// DAO to DTO
    private AddressDTO convertToEmpAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setaddressId(address.getaddressId());
        addressDTO.setDoorNo(address.getDoorNo());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setPostalCode(address.getPostalCode());
        return  addressDTO;
    }


}
