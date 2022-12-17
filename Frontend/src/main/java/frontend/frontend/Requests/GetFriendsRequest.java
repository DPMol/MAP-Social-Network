package frontend.frontend.Requests;

import frontend.frontend.Models.FriendshipDetails;

import java.util.List;

public class GetFriendsRequest implements AbstractRequest<FriendshipDetails[]> {
    protected String user;

    public GetFriendsRequest(String email) {
        this.user = email;
    }
}
