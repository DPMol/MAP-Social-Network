package backend.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(
        name = "Users"
)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "first_name", nullable = false)
    private String firstname;
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @Column(name = "password", nullable = false)
    private String password;
}
