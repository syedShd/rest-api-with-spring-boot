package com.rest.serviceapi.service;

import com.rest.serviceapi.dao.model.EmpContact;
import com.rest.serviceapi.dao.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements IContact {
    @Autowired
    ContactRepository contactRepository;
  //  private static final ContactService INSTANCE = new ContactService();

    /*
    static {
        Address address1 = new Address("8-3-169/452", "Hyderabad", "HF Nagar", "TS", "500045");
        Address address2 = new Address("78-4-563/4", "Hyderabad", "Padmavati Nagar", "TS", "500018");
        Address address3 = new Address("116-2-799/1/A", "Hyderabad", "Yousufguda", "TS", "500045");
        Address address4 = new Address("278-45-169/2", "Hyderabad", "Golnaka", "TS", "500014");
        Address address5 = new Address("54-7-67/2/C", "Hyderabad", "Site-3", "TS", "500018");

        EmpContact ob1 = new EmpContact("101","Rameez","Ahmed",address1,"rameezahmed34@gmail.com","9945723108");
        EmpContact ob2 = new EmpContact("102","Rahmath","Unnissa",address2,"rahmath45@gmail.com","8547123647");
        EmpContact ob3 = new EmpContact("103","Shareef","Pasha",address3,"p.shareef90@gmail.com","7897110367");
        EmpContact ob4 = new EmpContact("104","Zakir","Ahmed",address4,"ahmedzakir0@gmail.com","9711078410");
        EmpContact ob5 = new EmpContact("105","Ismail","Hussain",address5,"h.ismail231@gmail.com","6710789713");
        EmpContact ob6 = new EmpContact("106","Fayaz","Hussain",address5,"h.fayaz28@gmail.com","9107812313");

        contacts.add(ob1);
        contacts.add(ob2);
        contacts.add(ob3);
        contacts.add(ob4);
        contacts.add(ob5);
        contacts.add(ob6);
    }*/


    @Override
    public EmpContact addEmpContact(EmpContact employee) {
        return contactRepository.save(employee);
    }

    @Override
    public EmpContact updateEmpContact(int id, EmpContact employee) {
        return contactRepository.save(employee);
    }

    @Override
    public EmpContact removeEmpContact(int id) {
        contactRepository.deleteById(id);
        return null;
    }

    @Override
    public EmpContact getContactById(int id) {


        /*   for (EmpContact contact : getAllContacts()){
            if (contact.getId().equals(id)) {
                detail = contact;
            }
        }*/
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmpContact> getAllContacts() {
        List<EmpContact> contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);
        return contacts;
    }
   /* public static ContactService getInstance() {
        return INSTANCE;
    }*/
}
