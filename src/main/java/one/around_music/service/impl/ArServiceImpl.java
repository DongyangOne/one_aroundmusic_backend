package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.dto.CustomException;
import one.around_music.common.util.SecurityUtil;
import one.around_music.domain.Ar;
import one.around_music.domain.Marker;
import one.around_music.domain.Music;
import one.around_music.domain.User;
import one.around_music.dto.ar.RequestArSaveDto;
import one.around_music.repository.ar.ArJpaRepository;
import one.around_music.repository.marker.MarkerJpaRepository;
import one.around_music.repository.music.MusicJpaRepository;
import one.around_music.repository.user.UserJpaRepository;
import one.around_music.service.ArService;
import one.around_music.vo.ArVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArServiceImpl implements ArService {

    private final UserJpaRepository userJpaRepository;
    private final ArJpaRepository arJpaRepository;
    private final MusicJpaRepository musicJpaRepository;
    private final MarkerJpaRepository markerJpaRepository;

    @Override
    public ResponseEntity<?> saveAr(RequestArSaveDto dto) {

        User findUser = SecurityUtil.getCurrentUserId(userJpaRepository);
        Marker marker = markerJpaRepository.save(Marker.builder().longitude(dto.getLongitude()).latitude(dto.getLatitude()).build());
        Music saveMusic = musicJpaRepository.save(Music.builder().youtubId(dto.getYoutubeId()).title(dto.getTitle()).thumbnail(dto.getThumbnail()).build());

        arJpaRepository.save(Ar.builder().user(findUser).music(saveMusic).marker(marker).latitude(dto.getLatitude()).longitude(dto.getLongitude()).build());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "AR게시에 성공했습니다.");

    }

    @Override
    public ResponseEntity<?> findAllAr(Long markerId) {

        Optional<Marker> findMarker = markerJpaRepository.findById(markerId);

        if(findMarker.isEmpty()) {
            throw new CustomException("마커 정보를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }

        List<ArVo> arList = arJpaRepository.findArList(markerId);

        return CommonResponse.createResponse(HttpStatus.OK.value(), "마커에 해당하는 AR을 조회합니다.", arList);
    }

    @Override
    public ResponseEntity<?> deleteAr(Long arId) {
        Optional<Ar> findAr = arJpaRepository.findById(arId);
        if(findAr.isEmpty()) {
            throw new CustomException("해당 AR을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }
        arJpaRepository.delete(findAr.get());
        markerJpaRepository.delete(findAr.get().getMarker());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "AR삭제를 성공했습니다.");
    }
}
