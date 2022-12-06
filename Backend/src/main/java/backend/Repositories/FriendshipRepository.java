package backend.Repositories;

import backend.Domain.Friendship;
import backend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE (f.sender = ?1 and f.receiver = ?2) " +
                        "or (f.sender = ?2 and f.receiver = ?1) "
    )
    Optional<Friendship> findFriendship(User user1, User user2);

    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE f.receiver = ?1 or f.sender = ?1"
    )
    List<Friendship> findAllFriendshipsByUser(User user);

    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE f.accepted = ?2 and (f.receiver = ?1 or f.sender = ?1)"
    )
    List<Friendship> findAllFriendshipsByUser(User user, Boolean accepted);

    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE f.sender = ?1"
    )
    List<Friendship> findAllSentFriendshipsByUser(User user);

    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE f.sender = ?1 and f.accepted = ?2"
    )
    List<Friendship> findAllSentFriendshipsByUser(User user, Boolean accepted);

    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE f.receiver = ?1"
    )
    List<Friendship> findAllReceivedFriendshipsByUser(User user);

    @Query(
            value = "SELECT f FROM Friendship f " +
                    "WHERE f.receiver = ?1 and f.accepted = ?2"
    )
    List<Friendship> findAllReceivedFriendshipsByUser(User user, Boolean accepted);
}
