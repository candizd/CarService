package com.example.se_project2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cars {

    private StringProperty price;
    private IntegerProperty ID;
    private StringProperty brand;
    private StringProperty model;
    private StringProperty horsepower;
    private StringProperty section;

    public Cars() {
        this.price = new SimpleStringProperty();
        this.ID = new SimpleIntegerProperty();
        this.brand = new SimpleStringProperty();
        this.model  = new SimpleStringProperty();
        this.horsepower = new SimpleStringProperty();
        this.section = new SimpleStringProperty();
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

    public int getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public StringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getHorsepower() {
        return horsepower.get();
    }

    public StringProperty horsepowerProperty() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower.set(horsepower);
    }

    public String getSection() {
        return section.get();
    }

    public StringProperty sectionProperty() {
        return section;
    }

    public void setSection(String section) {
        this.section.set(section);
    }
}