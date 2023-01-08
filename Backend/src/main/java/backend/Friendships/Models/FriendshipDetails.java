package backend.Friendships.Models;

import backend.Domain.Friendship;
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
public class FriendshipDetails {
    private UserDetails friend;
    private LocalDateTime createdDate;
    private LocalDateTime acceptedDate;
    private Boolean accepted;

    public static List<FriendshipDetails> FromFriendships(User user, List<Friendship> friendshipList){
        return friendshipList.stream().map( friendship -> {
            if(Objects.equals(friendship.getReceiver(), user))
                return new FriendshipDetails(UserDetails.FromUser(friendship.getSender()), friendship.getCreatedDate(), friendship.getAcceptedDate(), friendship.getAccepted());
            if(Objects.equals(friendship.getSender(), user))
                return new FriendshipDetails(UserDetails.FromUser(friendship.getReceiver()), friendship.getCreatedDate(), friendship.getAcceptedDate(), friendship.getAccepted());
            return null;
        }).collect( Collectors.toList());
    }
}
