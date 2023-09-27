package one.around_music.repository.userReward;

import one.around_music.enums.RewardType;
import one.around_music.vo.UserRewardVo;

public interface UserRewardCustomRepository {
    String findReward(Long userId, RewardType rewardType);
}
