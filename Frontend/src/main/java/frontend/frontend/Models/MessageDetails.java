package frontend.frontend.Models;

import java.time.LocalDateTime;

public class MessageDetails {
    private String sender;
    private String sentDate;
    private String text;

    public MessageDetails(String sender, String sentDate, String text) {
        this.sender = sender;
        this.sentDate = sentDate;
        this.text = text;
    }

    public MessageDetails() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return sender + ", " +
                sentDate + ":\n\t" +
                text;
    }
}
