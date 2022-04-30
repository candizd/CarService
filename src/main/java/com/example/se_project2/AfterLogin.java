package com.example.se_project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class AfterLogin {

    @FXML
    private Button logout;
    @FXML
    private Button button_employee;
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
    private StackPane stackpane;
    @FXML
    private Button main_button;


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
    private void hideAllSceneItems() {

        stackpane.getChildren().forEach((scene) -> {
            scene.setVisible(false);
        });
    }
}