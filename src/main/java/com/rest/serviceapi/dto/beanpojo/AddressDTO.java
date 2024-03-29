package com.rest.serviceapi.dto.beanpojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class AddressDTO {
    @JsonIgnoreProperties({"id"})
    private Long id;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    public AddressDTO() { }

    @JsonIgnore
    public Long getaddressId() {
        return this.id;
    }
    @JsonIgnore
    public void setaddressId(Long id) {
        this.id = id;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


}
