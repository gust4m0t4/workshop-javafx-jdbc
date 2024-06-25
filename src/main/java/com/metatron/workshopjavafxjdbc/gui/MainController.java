package com.metatron.workshopjavafxjdbc.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;


    @FXML
    public void OnMenuItemSellerAction() {
        System.out.println("OnMenuItemSellerAction");
    }
    @FXML
    public void OnMenuItemDepartmentAction() {
        System.out.println("OnMenuItemDepartmentAction");
    }
    @FXML
    public void OnMenuItemAboutAction() {
        System.out.println("OnMenuItemAboutAction");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}