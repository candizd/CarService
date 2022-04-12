package com.example.se_project2;

public class Customer {
    private String customer_ID;
    protected String vorname;
    protected String nachname;
    protected String telefonnummer;
    protected String email;
    protected String adresse;

    public Customer(String customer_ID, String vorname, String nachname, String telefonnummer, String email, String adresse) {
        this.customer_ID = customer_ID;
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
        this.email = email;
    }

    public String getCustomer_ID() {
        return this.customer_ID;
    }
}