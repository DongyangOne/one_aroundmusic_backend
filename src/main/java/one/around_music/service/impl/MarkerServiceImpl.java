package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.util.SecurityUtil;
import one.around_music.domain.Marker;
import one.around_music.domain.User;
import one.around_music.dto.marker.RequestMarkerFindDto;
import one.around_music.enums.RewardType;
import one.around_music.repository.marker.MarkerJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.repository.userReward.UserRewardJpaRepositroy;
import one.around_music.service.MarkerService;
import one.around_music.vo.UserRewardVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkerServiceImpl implements MarkerService {

    private final MarkerJpaRepository markerJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final UserRewardJpaRepositroy userRewardJpaRepositroy;

    @Override
    public ResponseEntity<?> findAllMarker() {
        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        List<Marker> markerList = markerJpaRepository.findAll();
        UserRewardVo reward = userRewardJpaRepositroy.findReward(findUser.getId(), RewardType.WALKING);

        HashMap<String, Object> response = new HashMap<>();
        response.put("reward", reward);
        response.put("marker", markerList);

        return CommonResponse.createResponse(HttpStatus.OK.value(), "주변 마커를 조회합니다.", response);
    }

}
