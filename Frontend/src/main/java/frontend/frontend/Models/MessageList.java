package frontend.frontend.Models;

import java.util.List;

public class MessageList {
    private String friend;
    private List<MessageDetails> messages;

    public MessageList() {
    }

    public MessageList(String friend, List<MessageDetails> messages) {
        this.friend = friend;
        this.messages = messages;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public List<MessageDetails> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDetails> messages) {
        this.messages = messages;
    }
}
