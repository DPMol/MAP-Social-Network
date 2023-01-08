package backend.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(
        name = "Messages"
)
@Check(constraints = "sender_id != receiver_id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Message {
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

    @Column(name = "sent_date")
    private LocalDateTime sentDate;

    @Column(name = "text")
    private String text;

    public Message(User sender, User receiver, String text){
        this.sender = sender;
        this.receiver = receiver;
        sentDate = LocalDateTime.now();
        this.text = text;
    }
}
