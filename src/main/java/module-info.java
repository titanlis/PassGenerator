module ru.itm.pass {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.datatransfer;
    requires java.desktop;

    opens ru.itm.pass to javafx.fxml;
    exports ru.itm.pass;
    exports ru.itm.pass.controllers;
    opens ru.itm.pass.controllers to javafx.fxml;
}