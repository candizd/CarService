package com.example.se_project2;

import java.util.Date;

public class Bill {
    protected Date datum;
    protected int preis;
    private String bill_ID;

    public String getBill_ID() {
        return this.bill_ID;
    }

    public Bill(Date datum, int preis, String bill_ID) {
        this.datum = datum;
        this.preis = preis;
        this.bill_ID = bill_ID;
    }
}
