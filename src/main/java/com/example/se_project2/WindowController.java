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
    void addEmployee(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
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

            /*
            int status = statement.executeUpdate("insert into employee(employee_ID, username, password, email, telephone_number, department, Name, Surname)" +
                        "values('" + employee_ID2 + "', '" + username + "','" + password + "''" + email + "','" + tnumber + "','" + department + "','" + name + "','" + surname + "')");
            */
            int status = statement.executeUpdate("insert into employee (username,password,email,telephone_number,department)" +
                    " values('"+username+"','"+password+"','"+email+"','"+tnumber+"','" +department+"')");
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
    void deleteEmployee(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        Stage stage = (Stage) edel_button.getScene().getWindow();
        try {
            String username = del_employee.getText();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("delete from employee where username = '"+ username +"'");
            if(status > 0) {
                System.out.println("employee deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        stage.close();
    }

}

