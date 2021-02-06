package com.rest.serviceapi.dto.beanpojo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
public class EmpDTO {

    private int eId;
    private  String eName;
    private  String eEmail;
    private  String eGender;
    private  List<String> eSkillSet = new ArrayList<>();
    public EmpDTO() { }


    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public List<String> geteSkillSet() {
        return eSkillSet;
    }

    public void seteSkillSet(List<String> eSkillSet) {
        this.eSkillSet = eSkillSet;
    }



}
