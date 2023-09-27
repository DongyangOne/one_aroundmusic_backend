package one.around_music.repository.userReward;

import one.around_music.domain.UserReward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRewardJpaRepositroy extends JpaRepository<UserReward, Long>, UserRewardCustomRepository {
}
