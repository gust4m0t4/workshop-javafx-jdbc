module com.metatron.workshopjavafxjdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;

    opens com.metatron.workshopjavafxjdbc to javafx.fxml;
    exports com.metatron.workshopjavafxjdbc;
    exports com.metatron.workshopjavafxjdbc.gui;
    opens com.metatron.workshopjavafxjdbc.gui to javafx.fxml;
    opens com.metatron.workshopjavafxjdbc.model.entities to javafx.base;
}