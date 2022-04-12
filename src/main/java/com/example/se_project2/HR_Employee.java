package com.example.se_project2;

import java.util.ArrayList;

public class HR_Employee extends Employee {

    ArrayList<Employee> employees = new ArrayList<>();

    public HR_Employee(String passwort, String name, String nachname, String telefonnummer, String employee_ID, String bankkonto, String adresse, String abteilung, String email) {
        super(passwort, name, nachname, telefonnummer, employee_ID, bankkonto, adresse, abteilung, email);
    }

    public String getEmployee_ID() {
        return super.getEmployee_ID();
    }

    public void changePassword(String newPasswort, String Employee_ID) {
    }
    public void addNewEmployee(Employee e) {
        if(!employees.contains(e)) {
            employees.add(e);
        }
        else {
            System.out.println("Already exists.");
        }
    }
    public void removeEmployee(String id) {
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEmployee_ID().equals(id)) {
                employees.remove(i);
            }
        }
    }
    public Employee findEmployee(String id) {
        for(Employee e : employees) {
            if(e.getEmployee_ID().equals(id)) {
                return e;
            }
            else {
                System.out.println("Error");
            }
        }
        return null;
    }
}
