package frontend.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class LoginController {

    @FXML
    private TextField emailLoginField;
    @FXML
    private PasswordField passwordLoginField;

    @FXML
    private GridPane defaultGridPane;

    @FXML
    private void logIn() throws IOException {
//        String userName = emailLoginField.getText();
//        String password = passwordLoginField.getText();
        GridPane registerNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-form.fxml")));
        defaultGridPane.add(registerNode, 1, 2);
//        User user = service.findUser(userName);
//        if (user != null && user.getPassword().equals(password)) {
//            mainAppStartUp(actionEvent, user);
//        } else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Username or password invalid!");
//            alert.show();
//        }
    }

//    private void mainAppStartUp(ActionEvent actionEvent, User user) throws IOException {
//        Service.setCurrentLoggedUser(user);
//        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainapp-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
//        stage.setTitle("Welcome!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    private void signUpStartUp(ActionEvent actionEvent) throws IOException {
//        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
//        stage.setTitle("Sign up!");
//        stage.setScene(scene);
//        stage.show();
//    }
}
