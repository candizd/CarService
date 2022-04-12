package com.example.se_project2;

public class buying_customer extends Customer {
    private int gezahlter_Preis;

    public buying_customer(String customer_ID, String vorname, String nachname, String telefonnummer, String email, String adresse, int gezahlter_Preis) {
        super(customer_ID, vorname, nachname, telefonnummer, email, adresse);
        this.gezahlter_Preis = gezahlter_Preis;
    }

    public int getGezahlter_Preis() {
        return this.gezahlter_Preis;
    }
}
