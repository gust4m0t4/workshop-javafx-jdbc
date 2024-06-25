module com.metatron.workshopjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.metatron.workshopjavafxjdbc to javafx.fxml;
    exports com.metatron.workshopjavafxjdbc;
}