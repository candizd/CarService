package com.example.se_project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    private static Stage fakeStg;

    @Override
    public void start(Stage stage) throws IOException {
        fakeStg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        stage.setTitle("Car");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent wrong = FXMLLoader.load(getClass().getResource(fxml));
        fakeStg.getScene().setRoot(wrong);

    }
    public static void main(String[] args) {
        launch();
    }
}