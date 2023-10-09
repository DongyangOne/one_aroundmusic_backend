package one.around_music.repository.music;

import one.around_music.vo.MusicVo;

import java.util.List;

public interface MusicCustomRepository {
    List<MusicVo> findAllMusic();
}
