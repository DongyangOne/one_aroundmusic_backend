package one.around_music.repository.reward;

import one.around_music.domain.Reward;
import one.around_music.enums.RewardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RewardJpaRepository extends JpaRepository<Reward, Long>, RewardCustomRepository{
    Optional<Reward> findByReward(String reward);
    Optional<Reward> findFirstByRewardTypeOrderById(RewardType rewardType);
}
