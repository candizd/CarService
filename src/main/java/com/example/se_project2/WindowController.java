package com.example.se_project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WindowController {

    @FXML
    private Button esave_button;
    @FXML
    private Button edel_button;
    @FXML
    private AnchorPane adde_screen;
    @FXML
    private TextField add_username;
    @FXML
    private TextField add_password;
    @FXML
    private TextField add_name;
    @FXML
    private TextField add_surname;
    @FXML
    private TextField add_email;
    @FXML
    private TextField add_tnumber;
    @FXML
    private TextField add_department;
    @FXML
    private TextField del_employee;
    @FXML
    private TextField add_cname;
    @FXML
    private TextField add_csurname;
    @FXML
    private TextField add_cphone;
    @FXML
    private TextField add_cemail;
    @FXML
    private TextField add_csection;
    @FXML
    private TextField add_cadress;
    @FXML
    private Button customersave_button;
    @FXML
    private TextField add_brand;
    @FXML
    private TextField add_model;
    @FXML
    private TextField add_section;
    @FXML
    private TextField add_horsepower;
    @FXML
    private TextField add_price;
    @FXML
    private Button carsave_button;
    @FXML
    private TextField add_date;
    @FXML
    private TextField add_bprice;
    @FXML
    private Button billsave_button;

    @FXML
    void addEmployee(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        AfterLogin al = new AfterLogin();
        Stage stage = (Stage) esave_button.getScene().getWindow();
        try {
            String username = add_username.getText();
            String password = add_password.getText();
            String name = add_name.getText();
            String surname = add_surname.getText();
            String email = add_email.getText();
            String tnumber = add_tnumber.getText();
            String department = add_department.getText();
            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("insert into employee (username,name,surname,password,email,telephone_number,department)" +
                    " values('"+username+"', '"+name+"', '"+surname+"', '"+password+"', '"+email+"','"+tnumber+"', '" +department+"')");
            if (status > 0) {
                System.out.println("user registered");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        stage.close();
    }

    @FXML
    void addCustomer(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        Stage stage = (Stage) customersave_button.getScene().getWindow();
        try {
            String name = add_cname.getText();
            String surname = add_csurname.getText();
            String email = add_cemail.getText();
            String phone = add_cphone.getText();
            String section = add_csection.getText();
            String address = add_cadress.getText();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("insert into customer (name,surname,email,phone_number,section,address)" +
                    " values('"+name+"','"+surname+"','"+email+"','"+phone+"','" +section+"','"+address+"')");
            if (status > 0) {
                System.out.println("customer registered");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        stage.close();
    }
    @FXML
    void addCar(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        Stage stage = (Stage) carsave_button.getScene().getWindow();
        try {
            String brand = add_brand.getText();
            String model = add_model.getText();
            String section = add_section.getText();
            String horsepower = add_horsepower.getText();
            String price = add_price.getText();

            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("insert into car (brand,model,horsepower,section,price)" +
                    " values('"+brand+"','"+model+"','"+horsepower+"','" +section+"','"+price+"')");
            if (status > 0) {
                System.out.println("car registered");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        stage.close();
    }

    @FXML
    void addBill(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        Stage stage = (Stage) billsave_button.getScene().getWindow();

        try {

            String date = add_date.getText();
            String price = add_bprice.getText();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("insert into bill (date,price)" +
                    " values('" +date+"','"+price+"')");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        stage.close();
    }
}

