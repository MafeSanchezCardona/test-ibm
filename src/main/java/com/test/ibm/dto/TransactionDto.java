package com.test.ibm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO of the object Transaction
 */
public class TransactionDto implements Serializable {

    private static final long serialVersionUID = -1870879592639401742L;

    private Long id;
    private Date date;
    private String description;
    private Double amount;
    private Long cardNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
