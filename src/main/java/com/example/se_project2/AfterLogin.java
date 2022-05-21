package com.example.se_project2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.action.Action;
import org.w3c.dom.events.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AfterLogin  {

    @FXML
    private Button logout;
    @FXML
    private Button main_button;
    @FXML
    private Button button_employee;
    @FXML
    private Button adde_button;
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
    private Button addcustomer_button;
    @FXML
    private Button addcar_button;
    @FXML
    private StackPane main_stackpane;
    @FXML
    private AnchorPane main_screen;
    @FXML
    private AnchorPane employee_screen;
    @FXML
    private AnchorPane customer_screen;
    @FXML
    private AnchorPane cars_screen;
    @FXML
    private AnchorPane bills_screen;
    @FXML
    private AnchorPane settings_screen;

    @FXML
    private TableColumn<Employee, String> colEmpName;
    @FXML
    private TableColumn<Employee, String> colEmpSurname;
    @FXML
    private TableColumn<Employee, String> colEmpPhone;
    @FXML
    private TableColumn<Employee, String> colEmpEmail;
    @FXML
    private TableView employeeTable;

    SceneController sceneController = new SceneController();

    public void userLogOut(ActionEvent event) throws IOException {
        sceneController.logOut(event);
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
        if(event.getSource() == button_settings) {
            settings_screen.setVisible(true);
        }
        if(event.getSource() == main_button) {
            main_screen.setVisible(true);
        }
    }
    public void popUpEAdd(ActionEvent event) throws IOException {
        if(adde_button == event.getSource()) {
            sceneController.popUpWindow(event,"addEmployee.fxml");
        }
    }
    public void popUpEDelete(ActionEvent event) throws IOException {
        if(edel_button == event.getSource()) {
            sceneController.popUpWindow(event,"deleteEmployee.fxml");
        }
    }
    public void popUpCustomerAdd(ActionEvent event) throws IOException {
        if(addcustomer_button == event.getSource()) {
            sceneController.popUpWindow(event,"addCustomer.fxml");
        }
    }
    public void popUpCarAdd(ActionEvent event) throws IOException {
        if(addcar_button == event.getSource()) {
            sceneController.popUpWindow(event,"addCar.fxml");
        }
    }

    public void hideAllSceneItems() {

        main_stackpane.getChildren().forEach((scene) -> {
            scene.setVisible(false);
        });
    }

    @FXML
    private void initialize() throws Exception {
        colEmpName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colEmpSurname.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        colEmpPhone.setCellValueFactory(cellData -> cellData.getValue().telefonnummerProperty());
        colEmpEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        ObservableList<Employee> empList = db.getAllRecords();
        populateTable(empList);
    }

    private void populateTable(ObservableList<Employee> empList) {

        employeeTable.setItems(empList);


    }

}