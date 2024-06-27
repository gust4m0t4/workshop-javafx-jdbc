package com.metatron.workshopjavafxjdbc.gui;

import com.metatron.workshopjavafxjdbc.gui.util.Constraints;
import com.metatron.workshopjavafxjdbc.model.entities.Department;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentFormController implements Initializable {

    private Department entity;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private Label labelErrorName;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;

    public void setDepartment(Department entity) {
        this.entity = entity;
    }

    @FXML
    public void onBtSaveAction() {
        System.out.println("onBtSaveAction");
    }
    @FXML
    public void onBtCancelAction() {
        System.out.println("onBtCancelAction");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    private void initializeNodes() {
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 30);
    }
    public void updateFromData() {
        if (entity == null) {
         throw new IllegalArgumentException("Entity was null");
        }
            txtId.setText(String.valueOf(entity.getId()));
            txtName.setText(String.valueOf(entity.getName()));

    }


}
