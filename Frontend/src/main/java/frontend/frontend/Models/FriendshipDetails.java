package frontend.frontend.Models;

import java.time.LocalDateTime;

public class FriendshipDetails {
    private UserDetails friend;
    private String createdDate;
    private String acceptedDate;
    private Boolean accepted;

    public FriendshipDetails(UserDetails friend, String createdDate, String acceptedDate, Boolean accepted) {
        this.friend = friend;
        this.createdDate = createdDate;
        this.acceptedDate = acceptedDate;
        this.accepted = accepted;
    }

    public FriendshipDetails() {
    }

    public UserDetails getFriend() {
        return friend;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public Boolean getAccepted() {
        return accepted;
    }
}
