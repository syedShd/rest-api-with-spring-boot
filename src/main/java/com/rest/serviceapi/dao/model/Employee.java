package com.rest.serviceapi.dao.model;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    public Employee() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String name;
    private  String email;
    private  String gender;
    @ElementCollection
    private  List<String> skillSet = new ArrayList<>();

  /*  @Override
    public String toString()
    {
        return String.format("{id : %s, name : %s, email : %s, gender : %s, skillSet : %s }", id, name, email, gender, skillSet);
    }*/
}
