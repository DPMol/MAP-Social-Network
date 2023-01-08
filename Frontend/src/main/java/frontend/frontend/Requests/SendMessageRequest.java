package frontend.frontend.Requests;

public class SendMessageRequest implements AbstractRequest<Boolean> {

    private String sender;
    private String receiver;
    private String text;

    public SendMessageRequest(String sender, String receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }
}
