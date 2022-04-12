package com.example.se_project2;

import java.util.ArrayList;

public class sales_employee extends Employee {

    ArrayList<cars_sold> cars_sold = new ArrayList<>();
    ArrayList<buying_customer> buying_customers = new ArrayList<>();

    public sales_employee(String passwort, String name, String nachname, String telefonnummer, String employee_ID, String bankkonto, String adresse, String abteilung, String email) {
        super(passwort, name, nachname, telefonnummer, employee_ID, bankkonto, adresse, abteilung, email);
    }

    public void addNewCustomer(buying_customer c) {
        if(!buying_customers.contains(c)) {
            buying_customers.add(c);
        }
        else {
            System.out.println("Already exists.");
        }
    }
    public cars_sold findCars(String id) {
        for(cars_sold c : cars_sold) {
            if(c.getIdNumber().equals(id)) {
                return c;
            }
            else {
                System.out.println("Error");
            }
        }
        return null;
    }
    public buying_customer findCustomer(String id) {
        return null;
    }
    public void removeCustomer(String id) {}
    public void removeCar(String id) {}
}

