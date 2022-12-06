package backend.Friendships;

import backend.Domain.User;
import backend.Friendships.FriendshipRequests.*;
import backend.Friendships.Models.FriendshipDetails;
import backend.Infrastructure.AbstractClasses.AbstractController;
import backend.Users.Models.UserDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friendships")
@AllArgsConstructor
public class FriendshipController extends AbstractController {
    FriendshipService friendshipService;

    @PostMapping("/send")
    public Boolean sendFriendship(@Valid @RequestBody SendFriendshipRequest request){
        return friendshipService.handle(request);
    }

    @PostMapping("/accept")
    public Boolean acceptFriendship(@Valid @RequestBody AcceptFriendshipRequest request){
        return friendshipService.handle(request);
    }

    @PostMapping("/allfriends")
    public List<FriendshipDetails> getAllFriends(@Valid @RequestBody GetAllFriendsRequest request){
        return friendshipService.handle(request);
    }

    @PostMapping("/allpendingfriendships")
    public List<FriendshipDetails> getAllPendingFriendships(@Valid @RequestBody GetAllPendingFriendshipsRequest request){
        return friendshipService.handle(request);
    }

    @PostMapping("/allincomingfriendships")
    public List<FriendshipDetails> getAllIncomingFriendships(@Valid @RequestBody GetAllIncomingFriendshipsRequest request){
        return friendshipService.handle(request);
    }

    @PostMapping("/unfriend")
    public Boolean unfriend(@Valid @RequestBody UnfriendRequest request){
        return friendshipService.handle(request);
    }

    @PostMapping("/allpossiblefriendships")
    public List<UserDetails> unfriend(@Valid @RequestBody GetAllPossibleFriendships request){
        return friendshipService.handle(request);
    }
}
