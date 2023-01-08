package backend.Messages;

import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Messages.MessageRequests.GetMessagesRequest;
import backend.Messages.MessageRequests.SendMessageRequest;
import backend.Messages.Models.MessageList;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController extends AbstractController {
    MessageService messageService;

    @PostMapping("/send")
    public Boolean send(@Valid @RequestBody SendMessageRequest request){
        return messageService.handle(request);
    }

    @PostMapping("/get")
    public MessageList get(@Valid @RequestBody GetMessagesRequest request){
        return messageService.handle(request);
    }
}