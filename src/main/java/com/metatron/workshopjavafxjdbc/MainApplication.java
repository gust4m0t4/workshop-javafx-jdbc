package com.metatron.workshopjavafxjdbc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        ScrollPane scrollPane = fxmlLoader.load();

        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        Scene mainScene = new Scene(scrollPane);




        stage.setTitle("Sample javafx application");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}