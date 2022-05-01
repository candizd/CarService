package com.example.se_project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.action.Action;
import org.w3c.dom.events.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AfterLogin {

    static int employee_ID = 1;

    @FXML
    private Button logout;
    @FXML
    private Button esave_button;
    @FXML
    private Button main_button;
    @FXML
    private Button button_employee;
    @FXML
    private Button adde_button;
    @FXML
    private Button dele_button;
    @FXML
    private Button edel_button;
    @FXML
    private Button button_customer;
    @FXML
    private Button button_cars;
    @FXML
    private Button button_bills;
    @FXML
    private Button button_settings;
    @FXML
    private VBox main_screen;
    @FXML
    private VBox employee_screen;
    @FXML
    private VBox customer_screen;
    @FXML
    private VBox cars_screen;
    @FXML
    private VBox bills_screen;
    @FXML
    private VBox settings_screen;
    @FXML
    private VBox elist_screen;
    @FXML
    private AnchorPane dele_screen;
    @FXML
    private AnchorPane adde_screen;
    @FXML
    private StackPane stackpane;
    @FXML
    private TextField del_employee;
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


    public void userLogOut(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.logOutChangeScene("hello-view.fxml");
    }

    @FXML
    private void menuButtonClicks(ActionEvent event) {
        hideAllSceneItems();
        if(event.getSource() == button_employee) {
            employee_screen.setVisible(true);
        }
        if(event.getSource() == button_customer) {
            customer_screen.setVisible(true);
        }
        if(event.getSource() == button_cars) {
            cars_screen.setVisible(true);
        }
        if(event.getSource() == button_bills) {
            bills_screen.setVisible(true);
        }
        if(event.getSource() == button_bills) {
            bills_screen.setVisible(true);
        }
        if(event.getSource() == button_settings) {
            settings_screen.setVisible(true);
        }
        if(event.getSource() == main_button) {
            main_screen.setVisible(true);
        }

    }
    @FXML
    private void changeToAddEmployee(ActionEvent event) {
        if(event.getSource() == adde_button) {
            elist_screen.setVisible(false);
            adde_screen.setVisible(true);
        }
    }
    @FXML
    private void changeToDeleteEmployee(ActionEvent event) {
        elist_screen.setVisible(false);
        dele_screen.setVisible(true);
    }


    public void addNewEmployee(ActionEvent event) throws SQLException {
        if(event.getSource() == esave_button) {
            addEmployee();
            adde_screen.setVisible(false);
            elist_screen.setVisible(true);
        }
    }
    public void delEmployee(ActionEvent event) throws SQLException {
        if(event.getSource() == edel_button) {
            deleteEmployee();
            dele_screen.setVisible(false);
            elist_screen.setVisible(true);
        }
    }

    @FXML
    void addEmployee() throws SQLException {
        Connection connection = db.getInstance().getConnection();
        try {
            int employee_ID2 = employee_ID;
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
            int status = statement.executeUpdate("insert into employee (employee_ID,username,password,email,telephone_number,department)" +
                    " values('"+employee_ID2+"', '"+username+"','"+password+"','"+email+"','"+tnumber+"','" +department+"')");
            employee_ID++;
            if (status > 0) {
                System.out.println("user registered");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
    }
    @FXML
    void deleteEmployee() throws SQLException {
        Connection connection = db.getInstance().getConnection();
        try {
            String username = del_employee.getText();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("delete from employee where username = '"+ username +"'");
            if(status > 0) {
                System.out.println("employee deleted");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection.close();
    }
    public void hideAllSceneItems() {

        stackpane.getChildren().forEach((scene) -> {
            scene.setVisible(false);
        });
    }

}