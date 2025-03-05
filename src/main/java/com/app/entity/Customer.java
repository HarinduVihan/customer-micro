package com.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="customer_table")
public class Customer {

    @Id //to identify the primary key of a table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //telling what is the id generation strategy
    private int customerId;

    @Column(name = "customer_name") //represent the column of the table
    private String customerName;

    @Column(name = "customer_address") //represent the column of the table
    private String customerAddress;

    @Column(name = "customer_tel") //represent the column of the table
    private int customerTel;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(int customerTel) {
        this.customerTel = customerTel;
    }

}
