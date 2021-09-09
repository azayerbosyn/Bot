package com.telegram.bot.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
public class Rate implements Serializable {

  @Id()
  private String currency;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "createdAt")
  private Date createdAt;


  public Rate(String currency, Double amount) {
    this.amount = amount;
    this.currency = currency;
  }

  public Rate(String currency, Double amount, Date createdAt) {
    this.currency = currency;
    this.amount = amount;
    this.createdAt = createdAt;
  }

  public Rate() {
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

}
