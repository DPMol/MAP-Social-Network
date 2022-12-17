package frontend.frontend.Controllers;

import frontend.frontend.Requests.AcceptFriendRequest;
import frontend.frontend.Requests.UnfriendRequest;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class FriendIncomingController extends AbstractFriendElementController{
    @FXML
    private void accept() throws IOException {
        String receiver = authenticatedUser.getUser().getEmail();
        String sender = button.getParent().getId();

        var request = new AcceptFriendRequest(sender, receiver);

        var result = RequestDispatcher.Post(request, Boolean.class, Endpoints.Friendships + "accept");

        if(result){
            var element = button.getParent();
            VBox parent = (VBox) element.getParent();
            parent.getChildren().remove(element);
        }
    }
}
