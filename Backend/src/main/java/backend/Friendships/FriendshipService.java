package backend.Friendships;

import backend.Domain.Friendship;
import backend.Domain.User;
import backend.Friendships.FriendshipRequests.*;
import backend.Friendships.Models.FriendshipDetails;
import backend.Infrastructure.AbstractClasses.AbstractService;
import backend.Infrastructure.ErrorMessages;
import backend.Repositories.FriendshipRepository;
import backend.Repositories.UserRepository;
import backend.Users.Models.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FriendshipService extends AbstractService {
    private UserRepository userRepository;
    private FriendshipRepository friendshipRepository;

    public Boolean handle(SendFriendshipRequest request){
        if(Objects.equals(request.getReceiver(), request.getSender())){
            throw new IllegalStateException(ErrorMessages.DuplicateEmails);
        }
        var sender = getUser(request.getSender());
        var receiver = getUser(request.getReceiver());

        var result = friendshipRepository.findFriendship(sender, receiver);
        if(result.isPresent()){
            throw new IllegalStateException(ErrorMessages.FriendshipAlreadyExists);
        }
        var friendship = new Friendship(sender, receiver);
        friendshipRepository.save(friendship);
        return true;
    }

    public Boolean handle(AcceptFriendshipRequest request){
        var sender = getUser(request.getSender());
        var receiver = getUser(request.getReceiver());
        var result = friendshipRepository.findFriendship(sender, receiver);
        if(result.isEmpty()){
            throw new IllegalStateException(ErrorMessages.FriendshipNotFound);
        }
        var friendship = result.get();
        if(!Objects.equals(friendship.getReceiver().getEmail(), request.getReceiver())){
            throw new IllegalStateException(ErrorMessages.FriendshipInvalidReceiver);
        }
        friendship.accept();
        friendshipRepository.save(friendship);
        return true;
    }

    public List<FriendshipDetails> handle(GetAllFriendsRequest request) {
        var user = getUser(request.getUser());
        var friendshipList = friendshipRepository.findAllFriendshipsByUser(user, true);
        return FriendshipDetails.FromFriendships(user, friendshipList);
    }

    public List<FriendshipDetails> handle(GetAllPendingFriendshipsRequest request) {
        var user = getUser(request.getUser());
        var friendshipList = friendshipRepository.findAllSentFriendshipsByUser(user, false);
        return FriendshipDetails.FromFriendships(user, friendshipList);
    }

    public List<FriendshipDetails> handle(GetAllIncomingFriendshipsRequest request) {
        var user = getUser(request.getUser());
        var friendshipList = friendshipRepository.findAllReceivedFriendshipsByUser(user, false);
        return FriendshipDetails.FromFriendships(user, friendshipList);
    }

    private User getUser(String email){
        Optional<User> user = userRepository.findById(email);
        if(user.isEmpty()){
            throw new IllegalStateException(ErrorMessages.UserNotFound);
        }
        return user.get();
    }

    public Boolean handle(UnfriendRequest request) {
        var sender = getUser(request.getSender());
        var receiver = getUser(request.getReceiver());
        var result = friendshipRepository.findFriendship(sender, receiver);
        if(result.isEmpty()){
            throw new IllegalStateException(ErrorMessages.FriendshipNotFound);
        }
        friendshipRepository.delete(result.get());
        return true;
    }

    public List<UserDetails> handle(GetAllPossibleFriendships request) {
        var user = getUser(request.getEmail());

        var friends = FriendshipDetails.FromFriendships(user, friendshipRepository.findAllFriendshipsByUser(user)).stream().map(FriendshipDetails::getFriend).toList();
        var users = UserDetails.FromUsers(userRepository.findAll());

        return users.stream().filter(friends::contains).collect(Collectors.toList());
    }
}
