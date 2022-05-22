package com.example.se_project2;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;

public class Employee  {

    private String passwort;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty telefonnummer;
    private String employee_ID;
    protected String bankkonto;
    protected String adresse;
    protected String abteilung;
    private StringProperty email;


    public Employee() {
        this.name = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.telefonnummer = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTelefonnummer() {
        return telefonnummer.get();
    }

    public StringProperty telefonnummerProperty() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer.set(telefonnummer);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }
}