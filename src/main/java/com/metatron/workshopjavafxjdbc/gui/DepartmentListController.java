package com.metatron.workshopjavafxjdbc.gui;

import com.metatron.workshopjavafxjdbc.MainApplication;
import com.metatron.workshopjavafxjdbc.model.entities.Department;
import com.metatron.workshopjavafxjdbc.model.services.DepartmentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentListController implements Initializable {

    private DepartmentService service;

    @FXML
    private TableView<Department> departmentTableView;

    @FXML
    private TableColumn<Department, Integer> tableColumnId;

    @FXML
    private TableColumn<Department, String> tableColumnName;

    @FXML
    private Button btNew;

    private ObservableList<Department> observableList;

    @FXML
    public void onBtNewAction() {
        System.out.println("funcionou");
    }


    public void setDepartmentService(DepartmentService service) {
        this.service = service;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        Stage stage = (Stage) MainApplication.getMainScene().getWindow();
        departmentTableView.prefHeightProperty().bind(stage.heightProperty());

    }
    public void updateTableView() {
        if(service == null) {
            throw new IllegalArgumentException("Service was null");
        }
        List<Department> list = service.findAll();
        observableList = FXCollections.observableArrayList(list);
        departmentTableView.setItems(observableList);
    }
}
