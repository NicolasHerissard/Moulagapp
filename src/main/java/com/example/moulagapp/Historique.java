package com.example.moulagapp;

import java.time.LocalDate;
import java.util.Date;

public class Historique {

    private int id;
    private double fund;
    private int type;
    private String description;
    private String category;
    private double amount;
    private Date date;

    public Historique()
    {

    }

    public Historique(int id, double fund, int type, String description, double amount, String category, Date date) {
        this.id = id;
        this.fund = fund;
        this.type = type;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFund() {
        return fund;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
