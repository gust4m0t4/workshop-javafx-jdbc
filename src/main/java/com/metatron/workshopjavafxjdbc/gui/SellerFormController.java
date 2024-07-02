package com.metatron.workshopjavafxjdbc.gui;

import com.metatron.workshopjavafxjdbc.db.DbException;
import com.metatron.workshopjavafxjdbc.gui.listeners.DataChangeListener;
import com.metatron.workshopjavafxjdbc.gui.util.Alerts;
import com.metatron.workshopjavafxjdbc.gui.util.Constraints;
import com.metatron.workshopjavafxjdbc.gui.util.Utils;
import com.metatron.workshopjavafxjdbc.model.entities.Department;
import com.metatron.workshopjavafxjdbc.model.entities.Seller;
import com.metatron.workshopjavafxjdbc.model.exceptions.ValidationException;
import com.metatron.workshopjavafxjdbc.model.services.DepartmentService;
import com.metatron.workshopjavafxjdbc.model.services.SellerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class SellerFormController implements Initializable {

    private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    private Seller entity;

    private SellerService service;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private TextField txtBaseSalary;

    @FXML
    private Label labelErrorName;

    @FXML
    private Label labelErrorEmail;

    @FXML
    private Label labelErrorBirthDate;

    @FXML
    private Label labelErrorBaseSalary;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;

    public void setSeller(Seller entity) {
        this.entity = entity;
    }
    public void setSellerService(SellerService service) {
        this.service = service;
    }
    public void subscribeDataChangeListener(DataChangeListener listener) {
        dataChangeListeners.add(listener);

    }


    @FXML
    public void onBtSaveAction(ActionEvent event) {
        if (entity == null) {
            throw new IllegalStateException("Entity was null");
        }
        if (service == null) {
            throw new IllegalStateException("Service was null");
        }
        try {
            entity = getFormData();
            service.saveOrUpdate(entity);
            notifyDataChangeListeners();
            Utils.currentStage(event).close();
        }catch (ValidationException e) {
         setErrorMessages(e.getErrors());
        }
        catch (DbException e) {
            Alerts.showAlert("Error saving object", null, e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    private void notifyDataChangeListeners() {
        for(DataChangeListener listener : dataChangeListeners) {
            listener.onDataChanged();
        }
    }

    private Seller getFormData() {
        Seller obj = new Seller();

        ValidationException exception = new ValidationException("Validation error");

        obj.setId(Utils.tryParseToInt(txtId.getText()));

        if (txtName.getText() == null || txtName.getText().trim().equals("")) {
            exception.addError("name", "Field can't be empty");
        }

        obj.setName(txtName.getText());

        if (exception.getErrors().size() > 0) {
            throw exception;
        }


        return obj;
    }

    @FXML
    public void onBtCancelAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    private void initializeNodes() {
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 30);
        Constraints.setTextFieldDouble(txtBaseSalary);
        Constraints.setTextFieldMaxLength(txtEmail, 60);
        Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");
    }
    public void updateFromData() {
        if (entity == null) {
         throw new IllegalArgumentException("Entity was null");
        }
            txtId.setText(String.valueOf(entity.getId()));
            txtName.setText(String.valueOf(entity.getName()));
            txtEmail.setText(entity.getEmail());
            Locale.setDefault(Locale.US);
            txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
            if(entity.getBirthDate() != null) {
                dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
            }
    }
    private void setErrorMessages(Map<String, String> error) {
        Set<String> fields = error.keySet();

        if(fields.contains("name")) {
            labelErrorName.setText(error.get("name"));
        }

    }


}
