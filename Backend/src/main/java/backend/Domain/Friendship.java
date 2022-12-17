package backend.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "Friendships"
)
@Check(constraints = "sender_id != receiver_id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;
    @ManyToOne()
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "accepted_date")
    private LocalDateTime acceptedDate;
    @Column(name = "accepted")
    private Boolean accepted = false;

    public Friendship(User sender, User receiver){
        this.sender = sender;
        this.receiver = receiver;
        createdDate = LocalDateTime.now();
        accepted = false;
    }

    public void accept() {
        this.accepted = true;
        this.acceptedDate = LocalDateTime.now();
    }
}
