package com.test.ibm.dto;

import java.io.Serializable;

/**
 * DTO of the object Adviser
 */
public class AdviserDto implements Serializable {

    private static final long serialVersionUID = -3547433431765374606L;

    private Long identification;
    private String name;
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
