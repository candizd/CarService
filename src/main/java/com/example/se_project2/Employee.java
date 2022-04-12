package com.example.se_project2;

import java.util.ArrayList;

public class Employee {
    private String passwort;
    protected String name;
    protected String nachname;
    protected String telefonnummer;
    private String employee_ID;
    protected String bankkonto;
    protected String adresse;
    protected String abteilung;
    protected String email;

    public Employee(String passwort, String name, String nachname, String telefonnummer, String employee_ID, String bankkonto, String adresse, String abteilung, String email) {
        this.passwort = passwort;
        this.name = name;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
        this.employee_ID = employee_ID;
        this.bankkonto = bankkonto;
        this.adresse = adresse;
        this.abteilung = abteilung;
        this.email = email;
    }

    public String getEmployee_ID() {
        return this.employee_ID;
    }


}