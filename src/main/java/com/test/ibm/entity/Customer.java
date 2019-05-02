package com.test.ibm.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer", uniqueConstraints = {@UniqueConstraint(columnNames = "IDENTIFICATION")})
public class Customer implements Serializable {

    @Id
    @Column(name = "IDENTIFICATION", unique = true, nullable = false, length = 50)
    private Long identification;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;
    @Column(name = "CITY", nullable = false, length = 30)
    private String city;
    @Column(name = "TELEPHONE", nullable = false, length = 20)
    private Long telephone;
    @Ignore
    private String cardNumbers;

    public String getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(String cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

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

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
