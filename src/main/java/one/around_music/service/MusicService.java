package one.around_music.service;

import one.around_music.dto.music.RequestMusicSaveDto;
import org.springframework.http.ResponseEntity;

public interface MusicService {
    ResponseEntity<?> saveMusic(RequestMusicSaveDto dto);
    ResponseEntity<?> findAllMusic();
}
