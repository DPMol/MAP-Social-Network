package backend.Users.Models;

import backend.Domain.User;
import jakarta.persistence.Column;
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
    private String firstName;
    private String lastName;

    public static UserDetails FromUser(User user){
        return new UserDetails(user.getEmail(), user.getFirstName(), user.getLastName());
    }

    public static List<UserDetails> FromUsers(List<User> users){
        return users.stream().map(UserDetails::FromUser).toList();
    }
}
