package one.around_music.repository.userReward;

import one.around_music.domain.Reward;
import one.around_music.domain.User;
import one.around_music.domain.UserReward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRewardJpaRepositroy extends JpaRepository<UserReward, Long>, UserRewardCustomRepository {
    Optional<UserReward> findByRewardAndUser(Reward reward, User user);
}
