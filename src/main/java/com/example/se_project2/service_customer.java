package com.example.se_project2;

public class service_customer extends Customer {
    private String lizenznummer;

    public service_customer(String customer_ID, String vorname, String nachname, String telefonnummer, String email, String adresse, String lizenznummer) {
        super(customer_ID, vorname, nachname, telefonnummer, email, adresse);
        this.lizenznummer = lizenznummer;
    }

    public String getLizenznummer() {
        return this.lizenznummer;
    }
}

