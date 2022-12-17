package frontend.frontend.Controllers;

import frontend.frontend.Requests.UnfriendRequest;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class FriendPendingController extends AbstractFriendElementController{
    @FXML
    private void cancel() throws IOException {
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
}
