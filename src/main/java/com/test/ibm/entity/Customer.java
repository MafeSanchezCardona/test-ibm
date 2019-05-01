package com.test.ibm.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer", uniqueConstraints = {@UniqueConstraint(columnNames = "IDENTIFICATION")})
public class Customer implements Serializable {

    @Id
    @Column(name = "IDENTIFICATION", unique = true, nullable = false, length = 100)
    private Long identification;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;
    @Column(name = "CITY", nullable = false, length = 30)
    private String city;
    @Column(name = "TELEPHONE", nullable = false, length = 20)
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
