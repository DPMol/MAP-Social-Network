package frontend.frontend.Controllers;

import frontend.frontend.HelloApplication;
import frontend.frontend.Models.FriendshipDetails;
import frontend.frontend.Models.UserDetails;
import frontend.frontend.Requests.GetFriendsRequest;
import frontend.frontend.Requests.GetPossibleFriendsRequest;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class FriendsController extends AbstractController{
    @FXML
    private VBox friendsBox;

    @FXML
    private VBox addBox;

    @FXML
    private VBox pendingBox;

    @FXML
    private VBox incomingBox;


    @FXML
    private void populateFriends() throws IOException {
        var request = new GetFriendsRequest(authenticatedUser.getUser().getEmail());

        var result = RequestDispatcher.Post(request, FriendshipDetails[].class, Endpoints.Friendships + "allfriends");

        var box = friendsBox.getChildren();
        box.clear();
        for (var friendship: result) {
            Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/FriendElementView.fxml")));
            Label name = (Label) node.lookup("#name");
            name.setText(friendship.getFriend().getEmail());
            node.setId(friendship.getFriend().getEmail());
            box.add(node);
        }
    }

    @FXML
    private void populateAdd() throws IOException {
        var request = new GetPossibleFriendsRequest(authenticatedUser.getUser().getEmail());

        var result = RequestDispatcher.Post(request, UserDetails[].class, Endpoints.Friendships + "allpossiblefriendships");

        var box = addBox.getChildren();
        box.clear();
        for (var user: result) {
            Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/FriendAddView.fxml")));
            Label name = (Label) node.lookup("#name");
            name.setText(user.getEmail());
            node.setId(user.getEmail());
            box.add(node);
        }
    }

    @FXML
    private void populateIncoming() throws IOException {
        var request = new GetFriendsRequest(authenticatedUser.getUser().getEmail());

        var result = RequestDispatcher.Post(request, FriendshipDetails[].class, Endpoints.Friendships + "allincomingfriendships");

        var box = incomingBox.getChildren();
        box.clear();
        for (var friendship: result) {
            Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/FriendIncomingView.fxml")));
            Label name = (Label) node.lookup("#name");
            name.setText(friendship.getFriend().getEmail());
            node.setId(friendship.getFriend().getEmail());
            box.add(node);
        }
    }

    @FXML
    private void populatePending() throws IOException {
        var request = new GetFriendsRequest(authenticatedUser.getUser().getEmail());

        var result = RequestDispatcher.Post(request, FriendshipDetails[].class, Endpoints.Friendships + "allpendingfriendships");

        var box = pendingBox.getChildren();
        box.clear();
        for (var friendship: result) {
            Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/FriendPendingView.fxml")));
            Label name = (Label) node.lookup("#name");
            name.setText(friendship.getFriend().getEmail());
            node.setId(friendship.getFriend().getEmail());
            box.add(node);
        }
    }
}
