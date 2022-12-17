package frontend.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        var stageService = StageService.getInstance();

        Parent rootNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Views/LoginView.fxml")));
        Scene scene = new Scene(rootNode);

        stageService.changeStage(scene, "Application", false);

//      stage.getIcons().add(new Image((Objects.requireNonNull(HelloApplication.class.getResourceAsStream("Images/LoginBackground.png")))));
    }

    public static void main(String[] args) {
        launch();
    }
}