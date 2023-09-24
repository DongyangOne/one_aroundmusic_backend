package one.around_music.repository.friend;

import one.around_music.domain.Friend;
import one.around_music.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendJpaRepository extends JpaRepository<Friend, Long>, FriendCustomRepository {

    Optional<Friend> findByUserAndFriend(User user, User friend);


}
