package frontend.frontend.Controllers;

import frontend.frontend.Utils.AuthenticatedUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class AbstractFriendElementController {
    protected final AuthenticatedUser authenticatedUser = AuthenticatedUser.getInstance();
    @FXML
    protected Label name;

    @FXML
    protected Button button;
}
