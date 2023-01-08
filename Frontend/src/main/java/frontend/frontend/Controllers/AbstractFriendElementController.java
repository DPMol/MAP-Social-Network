package frontend.frontend.Controllers;

import frontend.frontend.Utils.AuthenticatedUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class AbstractFriendElementController extends  AbstractController{

    @FXML
    protected Label name;

    @FXML
    protected Button button;
}
