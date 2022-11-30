package SocialNetworkServer.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        name = "Users"
)
public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
