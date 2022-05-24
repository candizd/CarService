package com.example.se_project2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


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
    private Button delcustomer_button;
    @FXML
    private Button button_cars;
    @FXML
    private Button button_bills;
    @FXML
    private Button delbill_button;
    @FXML
    private Button delcar_button;
    @FXML
    private Button button_settings;
    @FXML
    private Button addcustomer_button;
    @FXML
    private Button addcar_button;
    @FXML
    private Button addBill_button;
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
    private TableColumn<Employee,String> colEmpUsername;
    @FXML
    private TableColumn<Employee, String> colEmpName;
    @FXML
    private TableColumn<Employee, String> colEmpSurname;
    @FXML
    private TableColumn<Employee, String> colEmpPhone;
    @FXML
    private TableColumn<Employee, String> colEmpEmail;
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Customer,String> colCustomerName;
    @FXML
    private TableColumn<Customer,String> colCustomerSurname;
    @FXML
    private TableColumn<Customer,String> colCustomerEmail;
    @FXML
    private TableColumn<Customer,String> colCustomerPhone;
    @FXML
    private TableColumn<Customer,String> colCustomerSection;
    @FXML
    private TableColumn<Customer,String> colCustomerAddress;
    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Cars,Integer> colCarID;
    @FXML
    private TableColumn<Cars,String> colCarBrand;
    @FXML
    private TableColumn<Cars,String> colCarModel;
    @FXML
    private TableColumn<Cars,String> colCarHorsepower;
    @FXML
    private TableColumn<Cars,String> colCarSection;
    @FXML
    private TableColumn<Cars,String> colCarPrice;
    @FXML
    private TableView<Cars> carTable;


    @FXML
    private TableColumn<Bill,Integer> colBillID;
    @FXML
    private TableColumn<Bill,String> colBillDate;
    @FXML
    private TableColumn<Bill,String> colBillPrice;
    @FXML
    private TableView<Bill> billTable;

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

    public void hideAllSceneItems() {

        main_stackpane.getChildren().forEach((scene) -> {
            scene.setVisible(false);
        });
    }

    public void popUpEAdd(ActionEvent event) throws IOException {
        if(adde_button == event.getSource()) {
            sceneController.popUpWindow(event,"addEmployee.fxml");
        }
    }
    public void popUpEDelete(ActionEvent event) throws IOException, SQLException {
        Connection connection = db.getInstance().getConnection();
        if(edel_button == event.getSource()) {
            Employee employee = employeeTable.getSelectionModel().getSelectedItem();
            String username = employee.getUsername();
            try {
                Statement statement = connection.createStatement();
                int status = statement.executeUpdate("delete from employee where username = '"+ username +"'");
                if(status > 0) {
                    System.out.println("employee deleted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            employeeTable.getItems().removeAll(employeeTable.getSelectionModel().getSelectedItem());
            connection.close();
        }
    }

    public void popUpCustomerAdd(ActionEvent event) throws IOException {
        if(addcustomer_button == event.getSource()) {
            sceneController.popUpWindow(event,"addCustomer.fxml");
        }
    }
    public void deleteCustomer(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        if(delcustomer_button == event.getSource()) {
            Customer customer = customerTable.getSelectionModel().getSelectedItem();
            String email = customer.getEmail();
            try {
                Statement statement = connection.createStatement();
                int status = statement.executeUpdate("delete from customer where email = '"+ email +"'");
                if(status > 0) {
                    System.out.println("customer deleted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            customerTable.getItems().removeAll(customerTable.getSelectionModel().getSelectedItem());
            connection.close();
        }
    }

    public void popUpCarAdd(ActionEvent event) throws IOException {
        if(addcar_button == event.getSource()) {
            sceneController.popUpWindow(event,"addCar.fxml");
        }
    }
    public void deleteCar(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        if(delcar_button == event.getSource()) {
            Cars car = carTable.getSelectionModel().getSelectedItem();
            Integer id = car.getID();
            try {
                Statement statement = connection.createStatement();
                int status = statement.executeUpdate("delete from car where car_ID = '"+ id +"'");
                if(status > 0) {
                    System.out.println("car entry deleted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            carTable.getItems().removeAll(carTable.getSelectionModel().getSelectedItem());
            connection.close();
        }
    }

    public void popUpBillAdd(ActionEvent event) throws IOException {
        if(addBill_button == event.getSource()) {
            sceneController.popUpWindow(event,"addBill.fxml");
        }
    }

    public void deleteBill(ActionEvent event) throws SQLException {
        Connection connection = db.getInstance().getConnection();
        if(delbill_button == event.getSource()) {
            Bill bill = billTable.getSelectionModel().getSelectedItem();
            Integer id = bill.getBill_ID();
            try {
                Statement statement = connection.createStatement();
                int status = statement.executeUpdate("delete from bill where id = '"+ id +"'");
                if(status > 0) {
                    System.out.println("bill entry deleted");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            billTable.getItems().removeAll(billTable.getSelectionModel().getSelectedItem());
            connection.close();
        }
    }


    @FXML
    private void initialize() throws Exception {
        colEmpUsername.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        colEmpName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colEmpSurname.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        colEmpPhone.setCellValueFactory(cellData -> cellData.getValue().telefonnummerProperty());
        colEmpEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        ObservableList<Employee> empList = db.getAllEmployeeRecords();
        populateEmployeeTable(empList);

        colCustomerName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        colCustomerSurname.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        colCustomerEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        colCustomerPhone.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        colCustomerSection.setCellValueFactory(cellData -> cellData.getValue().sectionProperty());
        colCustomerAddress.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        ObservableList<Customer> customers = db.getAllCustomerRecords();
        populateCustomerTable(customers);

        colCarID.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        colCarBrand.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        colCarModel.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        colCarHorsepower.setCellValueFactory(cellData -> cellData.getValue().horsepowerProperty());
        colCarSection.setCellValueFactory(cellData -> cellData.getValue().sectionProperty());
        colCarPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        ObservableList<Cars> cars = db.getAllCarRecords();
        populateCarTable(cars);

        colBillID.setCellValueFactory(cellData -> cellData.getValue().bill_IDProperty().asObject());
        colBillDate.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        colBillPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        ObservableList<Bill> bills = db.getAllBillRecords();
        populateBillTable(bills);

    }

    private void populateEmployeeTable(ObservableList<Employee> empList) {
        employeeTable.setItems(empList);
    }
    private void populateCustomerTable(ObservableList<Customer> customers) {
        customerTable.setItems(customers);
    }
    private void populateBillTable(ObservableList<Bill> bills) {
        billTable.setItems(bills);
    }
    private void populateCarTable(ObservableList<Cars> cars) {
        carTable.setItems(cars);
    }

}