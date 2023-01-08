package backend.Messages.Models;

import backend.Users.Models.UserDetails;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class MessageList {
    private String friend;
    private List<MessageDetails> messages;
}
