package frontend.frontend.Models;

public class UserDetails {
    private int Id;
    private String email;
    private String firstname;
    private String lastname;

    public UserDetails(int id, String email, String firstname, String lastname) {
        Id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDetails(){
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
