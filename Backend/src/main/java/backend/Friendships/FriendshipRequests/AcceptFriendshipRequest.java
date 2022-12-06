package backend.Friendships.FriendshipRequests;

import backend.Infrastructure.AbstractClasses.AbstractRequest;
import backend.Infrastructure.ErrorMessages;
import backend.Infrastructure.RegEx;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AcceptFriendshipRequest extends AbstractRequest {
    @NotBlank
    @Pattern(regexp = RegEx.Email, message = ErrorMessages.InvalidEmail)
    private final String sender;
    @NotBlank
    @Pattern(regexp = RegEx.Email, message = ErrorMessages.InvalidEmail)
    private final String receiver;
}
