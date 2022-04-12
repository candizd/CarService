package com.example.se_project2;

public class HR_Employee extends Employee {
    public HR_Employee(String passwort, String name, String nachname, String telefonnummer, String employee_ID, String bankkonto, String adresse, String abteilung, String email) {
        super(passwort, name, nachname, telefonnummer, employee_ID, bankkonto, adresse, abteilung, email);
    }

    public String getEmployee_ID() {
        return super.getEmployee_ID();
    }

    public void changePassword(String newPasswort, String Employee_ID) {
    }
}
