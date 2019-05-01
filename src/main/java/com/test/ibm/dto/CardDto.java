package com.test.ibm.dto;

public class CardDto {

    private Integer number;
    private Integer ccv;
    private String type;
    private Long customerIdentification;

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

    public Long getCustomerIdentification() {
        return customerIdentification;
    }

    public void setCustomerIdentification(Long customerIdentification) {
        this.customerIdentification = customerIdentification;
    }
}
