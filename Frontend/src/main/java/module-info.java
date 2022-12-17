module frontend.frontend{
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens frontend.frontend to javafx.fxml;
    opens frontend.frontend.Models to com.google.gson;
    opens frontend.frontend.Controllers to javafx.fxml;
    opens frontend.frontend.Requests to com.google.gson;
    exports frontend.frontend;
}