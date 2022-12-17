package frontend.frontend.Controllers;

import frontend.frontend.HelloApplication;
import frontend.frontend.Models.UserDetails;
import frontend.frontend.Requests.LoginRequest;
import frontend.frontend.StageService;
import frontend.frontend.Utils.AuthenticatedUser;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.JsonConverter;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;


public class LoginController extends AbstractController{

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;


    @FXML
    private void swap() throws IOException {
        Parent registerNode = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/RegisterView.fxml")));
        var scene = new Scene(registerNode);

        stageService.changeStage(scene);
    }

    @FXML
    private void login() throws IOException{
        String email = this.email.getText();
        String password = this.password.getText();

        //validate email + password

        var request = new LoginRequest(email, password);

        var result = RequestDispatcher.Post(request, UserDetails.class, Endpoints.Users + "login");

        var user = AuthenticatedUser.getInstance();
        user.setUser(result);

        System.out.println(Objects.equals(result.toString(), user.getUser().toString()));
        Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/FriendsView.fxml")));
        var scene = new Scene(node);
        stageService.changeStage(scene, false);
    }
}
