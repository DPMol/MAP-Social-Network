package frontend.frontend.Controllers;

import frontend.frontend.Requests.AddFriendRequest;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class FriendAddController extends AbstractFriendElementController{
    @FXML
    private void add() throws IOException {
        String sender = authenticatedUser.getUser().getEmail();
        String receiver = button.getParent().getId();

        System.out.println(sender + "  " + receiver);

        var request = new AddFriendRequest(sender, receiver);

        var result = RequestDispatcher.Post(request, Boolean.class, Endpoints.Friendships + "send");

        if(result){
            var element = button.getParent();
            VBox parent = (VBox) element.getParent();
            parent.getChildren().remove(element);
        }
    }
}
