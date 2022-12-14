package frontend.frontend.Requests;

import frontend.frontend.Models.UserDetails;

public class LoginRequest implements  AbstractRequest<UserDetails>{
    private String email;
    private String password;

    public LoginRequest(String email, String password){
        this.email = email;
        this.password = password;
    }
}
