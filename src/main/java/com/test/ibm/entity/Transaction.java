package com.test.ibm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class of the entity Transaction
 */
@Entity
@Table(name = "Transaction", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = -6856660853673590553L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long id;
    @Column(name = "DATE", nullable = false)
    private Date date;
    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;
    @Column(name = "AMOUNT", nullable = false, length = 12)
    private Double amount;
    @Column(name = "CARD_NUMBER", nullable = false, length = 16)
    private Long cardNumber;

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

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
}
