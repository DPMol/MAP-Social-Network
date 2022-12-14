package frontend.frontend.Controllers;

import frontend.frontend.HelloApplication;
import frontend.frontend.Requests.RegisterRequest;
import frontend.frontend.StageService;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class RegisterController extends AbstractController{

    private final StageService stageService = StageService.getInstance();
    @FXML
    private TextField email;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private PasswordField password;

    @FXML
    private void register() throws IOException {
        String email = this.email.getText();
        String password = this.password.getText();
        String firstName = this.firstname.getText();
        String lastName = this.lastname.getText();

        var request = new RegisterRequest(firstName,lastName,email, password);

        var result = RequestDispatcher.Post(request, Boolean.class, Endpoints.Users + "register");

        System.out.println(result);
        this.swap();
    }

    @FXML
    private void swap() throws IOException {
        Parent loginNode = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/LoginView.fxml")));
        var scene = new Scene(loginNode);

        stageService.changeStage(scene);
    }
}
