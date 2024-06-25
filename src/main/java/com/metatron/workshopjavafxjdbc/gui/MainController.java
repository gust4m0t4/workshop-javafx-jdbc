package com.metatron.workshopjavafxjdbc.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

import java.awt.*;

public class MainController {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vbox;

    @FXML
    public void initialize() {
        vbox.prefWidthProperty().bind(scrollPane.widthProperty());
        vbox.prefHeightProperty().bind(scrollPane.heightProperty());
    }

}