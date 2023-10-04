package one.around_music.repository.userReward;

import one.around_music.domain.UserReward;
import one.around_music.enums.RewardType;
import one.around_music.vo.UserRewardVo;

import java.util.Optional;

public interface UserRewardCustomRepository {
    UserRewardVo findReward(Long userId, RewardType rewardType);
    Long findUserReward(Long userId, RewardType rewardType);
}
