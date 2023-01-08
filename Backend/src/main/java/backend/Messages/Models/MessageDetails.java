package backend.Messages.Models;

import backend.Domain.Message;
import backend.Domain.User;
import backend.Users.Models.UserDetails;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class MessageDetails {
    private String sender;
    private LocalDateTime sentDate;
    private String text;

    public static List<MessageDetails> FromMessages(List<Message> messageList){
        return messageList.stream().map( message ->
                new MessageDetails(message.getSender().getFirstname(), message.getSentDate(), message.getText())
        ).collect( Collectors.toList());
    }
}
