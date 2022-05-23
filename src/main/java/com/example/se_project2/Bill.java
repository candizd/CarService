package com.example.se_project2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Bill {
    private StringProperty date;
    private StringProperty price;
    private IntegerProperty bill_ID;

    public Bill() {
        this.bill_ID = new SimpleIntegerProperty();
        this.date = new SimpleStringProperty();
        this.price = new SimpleStringProperty();
    }

    public int getBill_ID() {
        return bill_ID.get();
    }

    public IntegerProperty bill_IDProperty() {
        return bill_ID;
    }

    public void setBill_ID(int bill_ID) {
        this.bill_ID.set(bill_ID);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

}
