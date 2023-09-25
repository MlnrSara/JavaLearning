package com.springtutorial.firstspring.model;

import java.sql.Timestamp;

public class Product {

    private int id;
    private String name;
    private int quantity;
    private double price;
    //must add @
    private String address;
    private boolean availableOnline;
    private Timestamp lastRestock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    public Timestamp getLastRestock() {
        return lastRestock;
    }

    public void setLastRestock(Timestamp lastRestock) {
        this.lastRestock = lastRestock;
    }
}
