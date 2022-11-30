package SocialNetworkServer.Domain;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "Friendships"
)
@Check(constraints = "firstUser > secondUser")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_user")
    @ManyToOne
    @JoinColumn(name="email", nullable = false)
    private User firstUser;
    @Column(name = "first_user")
    @ManyToOne
    @JoinColumn(name="email", nullable = false)
    private User secondUser;
    private LocalDateTime createdDate;
}
