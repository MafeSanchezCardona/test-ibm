package com.test.ibm.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Adviser", uniqueConstraints = {@UniqueConstraint(columnNames = "IDENTIFICATION")})
public class Adviser implements Serializable {

    @Id
    @Column(name = "IDENTIFICATION", unique = true, nullable = false, length = 100)
    private Long identification;
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Column(name = "SPECIALTY", nullable = false, length = 50)
    private String specialty;

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
