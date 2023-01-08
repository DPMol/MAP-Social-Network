package frontend.frontend.Requests;

import frontend.frontend.Models.MessageList;

public class GetMessagesRequest extends AbstractMessageRequest<MessageList> {
    public GetMessagesRequest(String user, String friend) {
        super(user, friend);
    }
}
