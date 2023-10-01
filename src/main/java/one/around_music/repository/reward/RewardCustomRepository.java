package one.around_music.repository.reward;

import one.around_music.domain.Reward;
import one.around_music.enums.RewardType;
import one.around_music.vo.RewardVo;

import java.util.List;

public interface RewardCustomRepository {
    List<RewardVo> findAllByRewardType(RewardType rewardType);
}
