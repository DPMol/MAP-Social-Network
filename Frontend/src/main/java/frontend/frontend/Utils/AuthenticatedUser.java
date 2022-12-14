package frontend.frontend.Utils;

import frontend.frontend.Models.UserDetails;
import frontend.frontend.StageService;
import javafx.stage.Stage;

public class AuthenticatedUser {
    private static AuthenticatedUser instance;
    UserDetails user;
    String friend;

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    private AuthenticatedUser(){}

    public static AuthenticatedUser getInstance() {
        if (instance == null) {
            instance = new AuthenticatedUser();
        }
        return instance;
    }
}
