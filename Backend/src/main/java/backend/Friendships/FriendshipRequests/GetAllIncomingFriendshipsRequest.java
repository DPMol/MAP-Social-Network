package backend.Friendships.FriendshipRequests;

import backend.Infrastructure.ErrorMessages;
import backend.Infrastructure.RegEx;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllIncomingFriendshipsRequest {
    @NotBlank
    @Pattern(regexp = RegEx.Email, message = ErrorMessages.InvalidEmail)
    private String user;
}
