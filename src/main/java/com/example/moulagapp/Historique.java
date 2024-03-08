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
}
