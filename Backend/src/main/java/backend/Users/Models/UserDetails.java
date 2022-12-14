package backend.Users.Models;

import backend.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDetails {
    private String email;
    private String firstname;
    private String lastname;

    public static UserDetails FromUser(User user){
        return new UserDetails(user.getEmail(), user.getFirstname(), user.getLastname());
    }

    public static List<UserDetails> FromUsers(List<User> users){
        return users.stream().map(UserDetails::FromUser).toList();
    }
}
