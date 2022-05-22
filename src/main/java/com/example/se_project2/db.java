package com.example.se_project2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
public class db {
   /*
    public  static Connection conn = null;

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\hasan\\IdeaProjects\\SE_Project2 - Copy\\src\\main\\resources\\com\\example\\se_project2\\carservice.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM users");
            if(res.next()){
                System.out.println("username: "+res.getString("username")+" Pass: "+res.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    */

    public Connection getConnection() {
        String url = "jdbc:sqlite:C:\\Users\\hasan\\IdeaProjects\\SE_Project2\\src\\main\\resources\\com\\example\\se_project2\\carservice.db";
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static db getInstance() {
        return new db();
    }

    public static ObservableList<Employee> getAllEmployeeRecords() throws ClassNotFoundException, SQLException {
        Connection connection = db.getInstance().getConnection();
        String sql = "select name,surname,telephone_number,email FROM employee";

        try {
            Statement s = connection.createStatement();
            ResultSet rsSet = s.executeQuery(sql);
            ObservableList<Employee> empList = getEmployeeObjects(rsSet);
            connection.close();
            return empList;
        } catch (SQLException e) {
            System.out.println("Error occured while fetching");
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Employee> getEmployeeObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException {

        try {
            ObservableList<Employee> emplist = FXCollections.observableArrayList();
            while (rsSet.next()) {
                Employee emp = new Employee();
                emp.setName(rsSet.getString("name"));
                emp.setSurname(rsSet.getString("surname"));
                emp.setTelefonnummer(rsSet.getString("telephone_number"));
                emp.setEmail(rsSet.getString("email"));
                emplist.add(emp);
            }
            return emplist;

        } catch (Exception e) {
            System.out.println("Error occurred while fetching ");
            e.printStackTrace();
            throw e;
        }

    }

    public static ObservableList<Customer> getAllCustomerRecords() throws ClassNotFoundException, SQLException {
        Connection connection = db.getInstance().getConnection();
        String sql = "select name,surname,email,phone_number,section,address FROM customer";

        try {
            Statement s = connection.createStatement();
            ResultSet rsSet = s.executeQuery(sql);
            ObservableList<Customer> customers = getCustomerObjects(rsSet);
            connection.close();
            return customers;

        } catch (SQLException e) {
            System.out.println("Error occured while fetching");
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Customer> getCustomerObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException {

        try {
            ObservableList<Customer> customerList = FXCollections.observableArrayList();
            while (rsSet.next()) {
                Customer customer = new Customer();
                customer.setName(rsSet.getString("name"));
                customer.setSurname(rsSet.getString("surname"));
                customer.setPhone(rsSet.getString("phone_number"));
                customer.setEmail(rsSet.getString("email"));
                customer.setSection(rsSet.getString("section"));
                customer.setAddress(rsSet.getString("address"));
                customerList.add(customer);
            }
            return customerList;

        } catch (Exception e) {
            System.out.println("Error occurred while fetching ");
            e.printStackTrace();
            throw e;
        }


    }
}
