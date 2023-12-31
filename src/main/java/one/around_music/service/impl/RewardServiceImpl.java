package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.dto.CustomException;
import one.around_music.common.util.SecurityUtil;
import one.around_music.domain.Reward;
import one.around_music.domain.User;
import one.around_music.domain.UserReward;
import one.around_music.dto.reward.RequestRewardSaveDto;
import one.around_music.dto.reward.RequestSelectRewardDto;
import one.around_music.enums.RewardType;
import one.around_music.repository.reward.RewardJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.repository.userReward.UserRewardJpaRepositroy;
import one.around_music.service.RewardService;
import one.around_music.vo.RewardVo;
import one.around_music.vo.UserRewardVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService {

    private final UserJpaRepository userJpaRepository;
    private final UserRewardJpaRepositroy userRewardJpaRepositroy;
    private final RewardJpaRepository rewardJpaRepository;

    @Override
    public ResponseEntity<?> saveReward(RequestRewardSaveDto dto) {
        Optional<Reward> findReward = rewardJpaRepository.findByReward(dto.getReward());
        if(findReward.isPresent()) {
            throw new CustomException("이미 존재하는 리워드 입니다.", HttpStatus.BAD_REQUEST);
        }
        rewardJpaRepository.save(Reward.builder().reward(dto.getReward()).rewardType(dto.getRewardType()).build());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "리워드 저장에 성공했습니다.");
    }

    @Override
    public ResponseEntity<?> findAllReward(String rewardType) {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        RewardType rt;
        if(rewardType.equals("walk")) {
            rt = RewardType.WALKING;
        } else if(rewardType.equals("pop")) {
            rt = RewardType.POPULARITY;
        } else if(rewardType.equals("listen")) {
            rt = RewardType.LISTENING;
        } else {
            throw new CustomException("잘못된 요청 url입니다.", HttpStatus.BAD_REQUEST);
        }

        UserRewardVo selectReward = userRewardJpaRepositroy.findReward(findUser.getId(), rt);
        if(selectReward == null) {
            Reward defaultReward = rewardJpaRepository.findFirstByRewardTypeOrderById(rt).get();
            userRewardJpaRepositroy.save(UserReward.builder().user(findUser).reward(defaultReward).build());
            selectReward = userRewardJpaRepositroy.findReward(findUser.getId(), rt);
        }

        List<RewardVo> findReward = rewardJpaRepository.findAllByRewardType(rt);

        HashMap<String, Object> response = new HashMap<>();
        response.put("selectedReward", selectReward);
        response.put("rewards", findReward);

        return CommonResponse.createResponse(HttpStatus.OK.value(), "리워드 전체 조회에 성공했습니다.", response);
    }

    @Override
    public ResponseEntity<?> selectReward(RequestSelectRewardDto dto) {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);

        RewardType rt;
        if(dto.getRewardType().equals("walk")) {
            rt = RewardType.WALKING;
        } else if(dto.getRewardType().equals("pop")) {
            rt = RewardType.POPULARITY;
        } else if(dto.getRewardType().equals("listen")) {
            rt = RewardType.LISTENING;
        } else {
            throw new CustomException("리워트 타입 확인해주세요.", HttpStatus.BAD_REQUEST);
        }

        Long findUserReward = userRewardJpaRepositroy.findUserReward(findUser.getId(), rt);

        if(findUserReward == null) {
            Optional<Reward> reward = rewardJpaRepository.findFirstByRewardTypeOrderById(rt);
            if(reward.isEmpty()) {
                throw new CustomException("리워드 오류", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            userRewardJpaRepositroy.save(UserReward.builder().user(findUser).reward(reward.get()).build());
            throw new CustomException("오류로인해 기본값으로 재설정 되었습니다. 다시 요청해주세요.", HttpStatus.RESET_CONTENT);
        }

        UserReward userReward = userRewardJpaRepositroy.findById(findUserReward).get();
        Optional<Reward> reward = rewardJpaRepository.findById(dto.getSelect_id());
        if(reward.isEmpty()) {
            throw new CustomException("선택한 리워드를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        } else if(reward.get().getRewardType() != rt) {
            throw new CustomException("리워드 타입이 잘못 되었습니다.", HttpStatus.BAD_REQUEST);
        }
        userReward.setReward(reward.get());
        userRewardJpaRepositroy.save(userReward);
        return CommonResponse.createResponse(HttpStatus.OK.value(), "리워드 적용에 성공했습니다.");
    }

    @Override
    public String getToken() {
        return rewardJpaRepository.getToken();
    }
}
