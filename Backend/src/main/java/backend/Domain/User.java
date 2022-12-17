package backend.Domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(
        name = "Users"
)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
