module frontend.frontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens frontend.frontend to javafx.fxml;
    exports frontend.frontend;
}