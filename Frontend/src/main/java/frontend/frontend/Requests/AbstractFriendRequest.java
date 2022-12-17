package frontend.frontend.Requests;

public abstract class AbstractFriendRequest implements AbstractRequest<Boolean>{
    private String sender;

    private String receiver;

    public AbstractFriendRequest(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
