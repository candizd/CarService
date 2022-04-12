package com.example.se_project2;

import java.util.ArrayList;

public class service_employee extends Employee {

    ArrayList<cars_service> cars_service = new ArrayList<>();
    ArrayList<service_customer> service_customers = new ArrayList<>();

    public service_employee(String passwort, String name, String nachname, String telefonnummer, String employee_ID, String bankkonto, String adresse, String abteilung, String email) {
        super(passwort, name, nachname, telefonnummer, employee_ID, bankkonto, adresse, abteilung, email);
    }

    public void addCars(cars_service c) {}
    public void addServiceCustomer(service_customer s) {}
    public void removeCars(String id) {}
    public void removeCustomer(String id) {}
}
