package frontend.frontend.Controllers;

import frontend.frontend.HelloApplication;
import frontend.frontend.Requests.AddFriendRequest;
import frontend.frontend.Requests.UnfriendRequest;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class FriendElementController extends AbstractFriendElementController{
    @FXML
    private void unfriend() throws IOException {
        String sender = authenticatedUser.getUser().getEmail();
        String receiver = button.getParent().getId();

        var request = new UnfriendRequest(sender, receiver);

        var result = RequestDispatcher.Post(request, Boolean.class, Endpoints.Friendships + "unfriend");

        if(result){
            var element = button.getParent();
            VBox parent = (VBox) element.getParent();
            parent.getChildren().remove(element);
        }
    }

    @FXML
    private void chat() throws IOException{
        String friend = button.getParent().getId();

        authenticatedUser.setFriend(friend);
        Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/ChatView.fxml")));
        var scene = new Scene(node);

        stageService.changeStage(scene, true);
    }
}
