package one.around_music.service.impl;

import lombok.RequiredArgsConstructor;
import one.around_music.common.dto.CommonResponse;
import one.around_music.domain.Music;
import one.around_music.dto.music.RequestMusicSaveDto;
import one.around_music.repository.music.MusicJpaRepository;
import one.around_music.service.MusicService;
import one.around_music.vo.MusicVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicJpaRepository musicJpaRepository;
    @Override
    public ResponseEntity<?> saveMusic(RequestMusicSaveDto dto) {
        Optional<Music> findMusic = musicJpaRepository.findByYoutubId(dto.getYoutubeId());
        if(findMusic.isPresent()) {
            return CommonResponse.createResponse(HttpStatus.OK.value(), "저장된 음악을 불러왔습니다.", findMusic);
        }
        musicJpaRepository.save(Music.builder().youtubId(dto.getYoutubeId()).title(dto.getTitle()).thumbnail(dto.getThumbnail()).build());
        return CommonResponse.createResponse(HttpStatus.OK.value(), "음악을 저장했습니다.");
    }

    @Override
    public ResponseEntity<?> findAllMusic() {
        List<MusicVo> musics = musicJpaRepository.findAllMusic();
        return CommonResponse.createResponse(HttpStatus.OK.value(), "음악을 조회합니다.", musics);
    }

}
