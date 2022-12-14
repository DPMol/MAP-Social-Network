package frontend.frontend.Requests;

public class RegisterRequest implements AbstractRequest<Boolean>{
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    public RegisterRequest(String firstname, String lastname , String email, String password){
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
