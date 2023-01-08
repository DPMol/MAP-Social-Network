package backend.Repositories;

import backend.Domain.Friendship;
import backend.Domain.Message;
import backend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(
            value = "SELECT f FROM Message f " +
                    "WHERE (f.sender = ?1 and f.receiver = ?2) " +
                    "or (f.sender = ?2 and f.receiver = ?1) "
    )
    Optional<List<Message>> findMessages(User user1, User user2);
}
