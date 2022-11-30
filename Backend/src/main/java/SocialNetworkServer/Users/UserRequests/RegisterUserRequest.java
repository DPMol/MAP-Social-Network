package SocialNetworkServer.Users.UserRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class RegisterUserRequest {
    @NotBlank(message = "")
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String password;
}
