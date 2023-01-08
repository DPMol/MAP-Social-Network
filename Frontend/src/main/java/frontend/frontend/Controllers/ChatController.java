package frontend.frontend.Controllers;

import frontend.frontend.HelloApplication;
import frontend.frontend.Models.MessageList;
import frontend.frontend.Requests.*;
import frontend.frontend.Utils.Endpoints;
import frontend.frontend.Utils.RequestDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class ChatController extends AbstractController{

    @FXML
    private TextField textField;
    @FXML
    private Label friend;
    @FXML
    private ListView<String> messageList;

    @FXML
    public void initialize() throws IOException{
        refresh();
    }

    @FXML
    private void back() throws IOException {
        Parent node = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Views/FriendsView.fxml")));
        var scene = new Scene(node);

        stageService.changeStage(scene, false);
    }

    @FXML
    private void refresh() throws IOException{
        var user = authenticatedUser.getUser();
        var friend = authenticatedUser.getFriend();
        var request = new GetMessagesRequest(user.getEmail(), friend);

        var result = RequestDispatcher.Post(request, MessageList.class, Endpoints.Messages + "get");

        this.friend.setText(result.getFriend());

        var list = messageList.getItems();

        list.clear();
        for (var message: result.getMessages()) {
            list.add(message.toString());
        }
    }

    @FXML
    private void send() throws IOException{
        if(textField.getText().isBlank()){
            return;
        }
        var user = authenticatedUser.getUser();
        var friend = authenticatedUser.getFriend();
        var request = new SendMessageRequest(user.getEmail(), friend, textField.getText());

        textField.clear();
        var result = RequestDispatcher.Post(request, Boolean.class, Endpoints.Messages + "send");

        refresh();
    }
}
