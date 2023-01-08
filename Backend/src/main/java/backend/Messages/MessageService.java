package backend.Messages;

import backend.Domain.Message;
import backend.Domain.User;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Infrastructure.ErrorMessages;
import backend.Messages.MessageRequests.GetMessagesRequest;
import backend.Messages.MessageRequests.SendMessageRequest;
import backend.Messages.Models.MessageDetails;
import backend.Messages.Models.MessageList;
import backend.Repositories.MessageRepository;
import backend.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageService extends AbstractService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;
    public Boolean handle(SendMessageRequest request) {
        var sender = getUser(request.getSender());
        var receiver = getUser(request.getReceiver());
        var message = new Message(sender, receiver, request.getText());

        messageRepository.save(message);

        return true;
    }

    public MessageList handle(GetMessagesRequest request) {
        var user = getUser(request.getUser());
        var friend = getUser(request.getFriend());

        var messages = messageRepository.findMessages(user, friend);
        List<MessageDetails> list;
        if(messages.isEmpty()){
             list = new ArrayList<>();
        }
        else{
            list = MessageDetails.FromMessages(messages.get());
        }

        return new MessageList(friend.getEmail(), list);
    }

    private User getUser(String email){
        Optional<User> user = userRepository.findById(email);
        if(user.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }
        return user.get();
    }
}
