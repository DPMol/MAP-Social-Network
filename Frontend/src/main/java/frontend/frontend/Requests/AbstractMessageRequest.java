package frontend.frontend.Requests;

public class AbstractMessageRequest<Response> implements AbstractRequest<Response> {
    private String user;

    private String friend;

    public AbstractMessageRequest(String user, String friend) {
        this.user = user;
        this.friend = friend;
    }
}
