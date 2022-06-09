package com.example.se_project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.w3c.dom.Node;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class HelloController {
    public HelloController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField tf_password;

    SceneController sceneController = new SceneController();
    private static String Username = "";
    private static String Department = "";

    public void checkLogin(ActionEvent event) throws SQLException, IOException {
        if (event.getSource() == button) {
            String username, password;
            Username = tf_username.getText();
            username = tf_username.getText();
            password = tf_password.getText();
            Connection connection = db.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee where username = '" + username + "' and password = '" + password + "'");
            //ResultSet resultSet = statement.executeQuery("select * from employee where username = '" + username + "' and password = '" + password + "' and department = 'HR' "  );
            Department = resultSet.getString("department");
            if (resultSet.next()) {
                wrongLogIn.setText("Success!");
                sceneController.switchToAfter(event);

            } else {
                wrongLogIn.setText("Wrong username or password!");
            }
            connection.close();
        }
    }
    public String getUsername() {
        return Username;
    }
    public String getDepartment() {return Department;}

}