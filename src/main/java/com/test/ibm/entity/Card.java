package com.test.ibm.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Card", uniqueConstraints = {@UniqueConstraint(columnNames = "NUMBER")})
public class Card implements Serializable {

    @Id
    @Column(name = "NUMBER", unique = true, nullable = false, length = 16)
    private Integer number;
    @Column(name = "CCV", nullable = false, length = 4)
    private Integer ccv;
    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;
    @Column(name = "CUSTOMER_IDENTIFICATION", nullable = false, length = 100)
    private Long customerIdentification;

    public Long getCustomerIdentification() {
        return customerIdentification;
    }

    public void setCustomerIdentification(Long customerIdentification) {
        this.customerIdentification = customerIdentification;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCcv() {
        return ccv;
    }

    public void setCcv(Integer ccv) {
        this.ccv = ccv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
