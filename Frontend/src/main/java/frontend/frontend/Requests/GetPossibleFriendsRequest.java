package frontend.frontend.Requests;

import frontend.frontend.Models.FriendshipDetails;
import frontend.frontend.Models.UserDetails;

import java.util.List;

public class GetPossibleFriendsRequest implements AbstractRequest<UserDetails[]> {
    protected String user;

    public GetPossibleFriendsRequest(String email) {
        this.user = email;
    }
}
