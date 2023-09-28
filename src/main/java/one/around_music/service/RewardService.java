package one.around_music.service;

import one.around_music.dto.reward.RequestRewardSaveDto;
import one.around_music.dto.reward.RequestSelectRewardDto;
import one.around_music.enums.RewardType;
import org.springframework.http.ResponseEntity;

public interface RewardService {
    ResponseEntity<?> saveReward(RequestRewardSaveDto dto);
    ResponseEntity<?> findAllReward(String rewardType);
    ResponseEntity<?> selectReward(RequestSelectRewardDto dto);
}
