package SocialNetworkServer.Users;

import SocialNetworkServer.Users.UserRequests.RegisterUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    @Async
    public Future<String> register(@RequestBody RegisterUserRequest request){
        return null;
    }
}
