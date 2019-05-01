package com.test.ibm.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 3638084829475572651L;

    private Long identification;
    private String name;
    private String address;
    private String city;
    private Integer telephone;

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
